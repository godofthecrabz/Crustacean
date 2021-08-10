package main.engine.graphics.opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL30.*;

import java.util.List;
import java.util.Map;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import main.engine.IHud;
import main.engine.Scene;
import main.engine.SceneLight;
import main.engine.Window;
import main.engine.graphics.Camera;
import main.engine.graphics.IRenderer;
import main.engine.graphics.Transformation;
import main.engine.graphics.animation.AnimGameItem;
import main.engine.graphics.animation.AnimatedFrame;
import main.engine.graphics.lights.DirectionalLight;
import main.engine.graphics.lights.PointLight;
import main.engine.graphics.lights.SpotLight;
import main.engine.graphics.particles.IParticleEmitter;
import main.engine.items.GameItem;
import main.engine.items.SkyBox;
import main.engine.utility.Utils;

public class GLRenderer implements IRenderer {

    /**
     * Field of View in Radians
     */
    private static final float FOV = (float) Math.toRadians(60.0f);

    private static final float Z_NEAR = 0.01f;

    private static final float Z_FAR = 1000.f;
    
    private static final int MAX_POINT_LIGHTS = 5;

    private static final int MAX_SPOT_LIGHTS = 5;
    
    private ShadowMap shadowMap;

    private ShaderProgram depthShaderProgram;

    private ShaderProgram sceneShaderProgram;
    
    private ShaderProgram hudShaderProgram;
    
    private ShaderProgram skyBoxShaderProgram;
    
    private ShaderProgram particlesShaderProgram;
    
    private final Transformation transformation;
    
    private final float specularPower;

    public GLRenderer() {
    	transformation = new Transformation();
    	specularPower = 10f;
    }

    @Override
    public void init(Window window, Scene scene) throws Exception {
    	shadowMap = new ShadowMap();
    	
    	setupDepthShader();
    	setupSkyBoxShader();
    	setupSceneShader();
    	setupParticlesShader();
    	setupHudShader();
    }
    
    @Override
    public void render(Window window, Camera camera, Scene scene, IHud hud) {
        clear();
        
        // Render depth map before view ports has been set up
        renderDepthMap(window, camera, scene);

        glViewport(0, 0, window.getWidth(), window.getHeight());
        
        // Update projection and view atrices once per render cycle
        transformation.updateProjectionMatrix(FOV, window.getWidth(), window.getHeight(), Z_NEAR, Z_FAR);
        transformation.updateViewMatrix(camera);

        renderScene(window, camera, scene);
        
        renderSkyBox(window, camera, scene);
        
        renderParticles(window, camera, scene);
        
        renderHud(window, hud);
    }
    
    private void setupParticlesShader() throws Exception {
        particlesShaderProgram = new ShaderProgram();
        particlesShaderProgram.createVertexShader(Utils.loadResource("/main/resources/shaders/particles_vertex.vs"));
        particlesShaderProgram.createFragmentShader(Utils.loadResource("/main/resources/shaders/particles_fragment.fs"));
        particlesShaderProgram.link();

        particlesShaderProgram.createUniform("projectionMatrix");
        particlesShaderProgram.createUniform("modelViewMatrix");
        particlesShaderProgram.createUniform("texture_sampler");
    }
    
    private void setupDepthShader() throws Exception {
        depthShaderProgram = new ShaderProgram();
        depthShaderProgram.createVertexShader(Utils.loadResource("/main/resources/shaders/depth_vertex.vs"));
        depthShaderProgram.createFragmentShader(Utils.loadResource("/main/resources/shaders/depth_fragment.fs"));
        depthShaderProgram.link();

        depthShaderProgram.createUniform("orthoProjectionMatrix");
        depthShaderProgram.createUniform("modelLightViewMatrix");
        
        // Create uniform for joint matrices
        depthShaderProgram.createUniform("jointsMatrix");
    }
    
    private void setupSkyBoxShader() throws Exception {
        skyBoxShaderProgram = new ShaderProgram();
        skyBoxShaderProgram.createVertexShader(Utils.loadResource("/main/resources/shaders/sb_vertex.vs"));
        skyBoxShaderProgram.createFragmentShader(Utils.loadResource("/main/resources/shaders/sb_fragment.fs"));
        skyBoxShaderProgram.link();

        // Create uniforms for projection matrix
        skyBoxShaderProgram.createUniform("projectionMatrix");
        skyBoxShaderProgram.createUniform("modelViewMatrix");
        skyBoxShaderProgram.createUniform("texture_sampler");
        skyBoxShaderProgram.createUniform("ambientLight");
    }
    
    private void setupSceneShader() throws Exception {
        // Create shader
        sceneShaderProgram = new ShaderProgram();
        sceneShaderProgram.createVertexShader(Utils.loadResource("/main/resources/shaders/scene_vertex.vs"));
        sceneShaderProgram.createFragmentShader(Utils.loadResource("/main/resources/shaders/scene_fragment.fs"));
        sceneShaderProgram.link();

        // Create uniforms for modelView and projection matrices and texture
        sceneShaderProgram.createUniform("projectionMatrix");
        sceneShaderProgram.createUniform("modelViewMatrix");
        sceneShaderProgram.createUniform("texture_sampler");
        sceneShaderProgram.createUniform("normalMap");
        
        // Create uniform for material
        sceneShaderProgram.createMaterialUniform("material");
        
        // Create lighting related uniforms
        sceneShaderProgram.createUniform("specularPower");
        sceneShaderProgram.createUniform("ambientLight");
        sceneShaderProgram.createPointLightListUniform("pointLights", MAX_POINT_LIGHTS);
        sceneShaderProgram.createSpotLightListUniform("spotLights", MAX_SPOT_LIGHTS);
        sceneShaderProgram.createDirectionalLightUniform("directionalLight");
        sceneShaderProgram.createFogUniform("fog");
        
        // Create uniforms for shadow mapping
        sceneShaderProgram.createUniform("shadowMap");
        sceneShaderProgram.createUniform("orthoProjectionMatrix");
        sceneShaderProgram.createUniform("modelLightViewMatrix");
        
        // Create uniform for joint matrices
        sceneShaderProgram.createUniform("jointsMatrix");
    }
    
    private void setupHudShader() throws Exception {
        hudShaderProgram = new ShaderProgram();
        hudShaderProgram.createVertexShader(Utils.loadResource("/main/resources/shaders/hud_vertex.vs"));
        hudShaderProgram.createFragmentShader(Utils.loadResource("/main/resources/shaders/hud_fragment.fs"));
        hudShaderProgram.link();

        // Create uniforms for Ortographic-model projection matrix and base colour
        hudShaderProgram.createUniform("projModelMatrix");
        hudShaderProgram.createUniform("color");
        hudShaderProgram.createUniform("hasTexture");
    }

    public void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }
    
    private void renderParticles(Window window, Camera camera, Scene scene) {
        if (scene.getParticleEmitters() != null) {
        	particlesShaderProgram.bind();

            particlesShaderProgram.setUniform("texture_sampler", 0);
            Matrix4f projectionMatrix = transformation.getProjectionMatrix();
            particlesShaderProgram.setUniform("projectionMatrix", projectionMatrix);

            Matrix4f viewMatrix = transformation.getViewMatrix();
            IParticleEmitter[] emitters = scene.getParticleEmitters();
            int numEmitters = emitters != null ? emitters.length : 0;

            glDepthMask(false);
            glBlendFunc(GL_SRC_ALPHA, GL_ONE);

            for (int i = 0; i < numEmitters; i++) {
                IParticleEmitter emitter = emitters[i];
                Mesh mesh = emitter.getBaseParticle().getMesh();

                mesh.renderList((emitter.getParticles()), (GameItem gameItem) -> {
                    Matrix4f modelMatrix = transformation.buildModelMatrix(gameItem);

                    viewMatrix.transpose3x3(modelMatrix);

                    Matrix4f modelViewMatrix = transformation.buildModelViewMatrix(modelMatrix, viewMatrix);
                    modelViewMatrix.scale(gameItem.getScale());
                    particlesShaderProgram.setUniform("modelViewMatrix", modelViewMatrix);
                }
                );
            }

            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            glDepthMask(true);

            particlesShaderProgram.unbind();
        }
    }
    
    private void renderDepthMap(Window window, Camera camera, Scene scene) {
        // Setup view port to match the texture size
        glBindFramebuffer(GL_FRAMEBUFFER, shadowMap.getDepthMapFBO());
        glViewport(0, 0, ShadowMap.SHADOW_MAP_WIDTH, ShadowMap.SHADOW_MAP_HEIGHT);
        glClear(GL_DEPTH_BUFFER_BIT);

        depthShaderProgram.bind();

        DirectionalLight light = scene.getSceneLight().getDirectionalLight();
        Vector3f lightDirection = light.getDirection();

        float lightAngleX = (float)Math.toDegrees(Math.acos(lightDirection.z));
        float lightAngleY = (float)Math.toDegrees(Math.asin(lightDirection.x));
        float lightAngleZ = 0;
        Matrix4f lightViewMatrix = transformation.updateLightViewMatrix(new Vector3f(lightDirection).mul(light.getShadowPosMult()), new Vector3f(lightAngleX, lightAngleY, lightAngleZ));
        DirectionalLight.OrthoCoords orthCoords = light.getOrthoCoords();
        Matrix4f orthoProjMatrix = transformation.updateOrthoProjectionMatrix(orthCoords.left, orthCoords.right, orthCoords.bottom, orthCoords.top, orthCoords.near, orthCoords.far);

        depthShaderProgram.setUniform("orthoProjectionMatrix", orthoProjMatrix);
        Map<Mesh, List<GameItem>> mapMeshes = scene.getGameMeshes();
        for (Mesh mesh : mapMeshes.keySet()) {
            mesh.renderList(mapMeshes.get(mesh), (GameItem gameItem) -> {
                Matrix4f modelLightViewMatrix = transformation.buildModelViewMatrix(gameItem, lightViewMatrix);
                depthShaderProgram.setUniform("modelLightViewMatrix", modelLightViewMatrix);
                
                if ( gameItem instanceof AnimGameItem ) {
                    AnimGameItem animGameItem = (AnimGameItem)gameItem;
                    AnimatedFrame frame = animGameItem.getCurrentFrame();
                    depthShaderProgram.setUniform("jointsMatrix", frame.getJointMatrices());
                }
            }
            );
        }

        // Unbind
        depthShaderProgram.unbind();
        glBindFramebuffer(GL_FRAMEBUFFER, 0);
    }
    
    private void renderSkyBox(Window window, Camera camera, Scene scene) {
    	SkyBox skyBox = scene.getSkyBox();
        if (skyBox != null) {
            skyBoxShaderProgram.bind();

            skyBoxShaderProgram.setUniform("texture_sampler", 0);

            Matrix4f projectionMatrix = transformation.getProjectionMatrix();
            skyBoxShaderProgram.setUniform("projectionMatrix", projectionMatrix);
            Matrix4f viewMatrix = transformation.getViewMatrix();
            viewMatrix.m30(0);
            viewMatrix.m31(0);
            viewMatrix.m32(0);
            Matrix4f modelViewMatrix = transformation.buildModelViewMatrix(skyBox, viewMatrix);
            skyBoxShaderProgram.setUniform("modelViewMatrix", modelViewMatrix);
            skyBoxShaderProgram.setUniform("ambientLight", scene.getSceneLight().getSkyBoxLight());

            scene.getSkyBox().getMesh().render();

            skyBoxShaderProgram.unbind();
        }
    }
    
    public void renderScene(Window window, Camera camera, Scene scene) {

        sceneShaderProgram.bind();

        // Update projection Matrix
        Matrix4f projectionMatrix = transformation.getProjectionMatrix();
        sceneShaderProgram.setUniform("projectionMatrix", projectionMatrix);
        Matrix4f orthoProjMatrix = transformation.getOrthoProjectionMatrix();
        sceneShaderProgram.setUniform("orthoProjectionMatrix", orthoProjMatrix);
        Matrix4f lightViewMatrix = transformation.getLightViewMatrix();

        // Update view Matrix
        Matrix4f viewMatrix = transformation.getViewMatrix();

        SceneLight sceneLight = scene.getSceneLight();
        renderLights(viewMatrix, sceneLight);

        sceneShaderProgram.setUniform("fog", scene.getFog());
        sceneShaderProgram.setUniform("texture_sampler", 0);
        sceneShaderProgram.setUniform("normalMap", 1);
        sceneShaderProgram.setUniform("shadowMap", 2);
        
        // Render each gameItem
        Map<Mesh, List<GameItem>> mapMeshes = scene.getGameMeshes();
        for (Mesh mesh : mapMeshes.keySet()) {
        	sceneShaderProgram.setUniform("material", mesh.getMaterial());
        	glActiveTexture(GL_TEXTURE2);
            glBindTexture(GL_TEXTURE_2D, shadowMap.getDepthMapTexture().getId());
            mesh.renderList(mapMeshes.get(mesh), (GameItem gameItem) -> {
            	Matrix4f modelViewMatrix = transformation.buildModelViewMatrix(gameItem, viewMatrix);
                sceneShaderProgram.setUniform("modelViewMatrix", modelViewMatrix);
                Matrix4f modelLightViewMatrix = transformation.buildModelLightViewMatrix(gameItem, lightViewMatrix);
                sceneShaderProgram.setUniform("modelLightViewMatrix", modelLightViewMatrix);
                
                if ( gameItem instanceof AnimGameItem ) {
                    AnimGameItem animGameItem = (AnimGameItem)gameItem;
                    AnimatedFrame frame = animGameItem.getCurrentFrame();
                    sceneShaderProgram.setUniform("jointsMatrix", frame.getJointMatrices());
                }
            }
            );
        }

        sceneShaderProgram.unbind();
    }
    
    private void renderLights(Matrix4f viewMatrix, SceneLight sceneLight) {

    	sceneShaderProgram.setUniform("ambientLight", sceneLight.getAmbientLight());
    	sceneShaderProgram.setUniform("specularPower", specularPower);

        // Process Point Lights
    	PointLight[] pointLightList = sceneLight.getPointLightList();
        int numLights = pointLightList != null ? pointLightList.length : 0;
        for (int i = 0; i < numLights; i++) {
            // Get a copy of the point light object and transform its position to view coordinates
            PointLight currPointLight = new PointLight(pointLightList[i]);
            Vector3f lightPos = currPointLight.getPosition();
            Vector4f aux = new Vector4f(lightPos, 1);
            aux.mul(viewMatrix);
            lightPos.x = aux.x;
            lightPos.y = aux.y;
            lightPos.z = aux.z;
            sceneShaderProgram.setUniform("pointLights", currPointLight, i);
        }

        // Process Spot Ligths
        SpotLight[] spotLightList = sceneLight.getSpotLightList();
        numLights = spotLightList != null ? spotLightList.length : 0;
        for (int i = 0; i < numLights; i++) {
            // Get a copy of the spot light object and transform its position and cone direction to view coordinates
            SpotLight currSpotLight = new SpotLight(spotLightList[i]);
            Vector4f dir = new Vector4f(currSpotLight.getConeDirection(), 0);
            dir.mul(viewMatrix);
            currSpotLight.setConeDirection(new Vector3f(dir.x, dir.y, dir.z));
            Vector3f lightPos = currSpotLight.getPointLight().getPosition();

            Vector4f aux = new Vector4f(lightPos, 1);
            aux.mul(viewMatrix);
            lightPos.x = aux.x;
            lightPos.y = aux.y;
            lightPos.z = aux.z;

            sceneShaderProgram.setUniform("spotLights", currSpotLight, i);
        }

        // Get a copy of the directional light object and transform its position to view coordinates
        DirectionalLight currDirLight = new DirectionalLight(sceneLight.getDirectionalLight());
        Vector4f dir = new Vector4f(currDirLight.getDirection(), 0);
        dir.mul(viewMatrix);
        currDirLight.setDirection(new Vector3f(dir.x, dir.y, dir.z));
        sceneShaderProgram.setUniform("directionalLight", currDirLight);

    }
    
    private void renderHud(Window window, IHud hud) {
        hudShaderProgram.bind();

        Matrix4f ortho = transformation.getOrtho2DProjectionMatrix(0, window.getWidth(), window.getHeight(), 0);
        for (GameItem gameItem : hud.getGameItems()) {
            Mesh mesh = gameItem.getMesh();
            // Set ortohtaphic and model matrix for this HUD item
            Matrix4f projModelMatrix = transformation.buildOrthoProjModelMatrix(gameItem, ortho);
            hudShaderProgram.setUniform("projModelMatrix", projModelMatrix);
            hudShaderProgram.setUniform("color", gameItem.getMesh().getMaterial().getAmbientColor());
            hudShaderProgram.setUniform("hasTexture", gameItem.getMesh().getMaterial().isTextured() ? 1 : 0);
            // Render the mesh for this HUD item
            mesh.render();
        }

        hudShaderProgram.unbind();
    }
    
    /**
     * Renders the three axis in space (For debugging purposes only
     * @param camera 
     */
    private void renderAxes(Camera camera) {
        glPushMatrix();
        glLoadIdentity();
        float rotX = camera.getRotation().x;
        float rotY = camera.getRotation().y;
        float rotZ = 0;
        glRotatef(rotX, 1.0f, 0.0f, 0.0f);
        glRotatef(rotY, 0.0f, 1.0f, 0.0f);
        glRotatef(rotZ, 0.0f, 0.0f, 1.0f);
        glLineWidth(2.0f);

        glBegin(GL_LINES);
        // X Axis
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(1.0f, 0.0f, 0.0f);
        // Y Axis
        glColor3f(0.0f, 1.0f, 0.0f);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, 1.0f, 0.0f);
        // Z Axis
        glColor3f(1.0f, 1.0f, 1.0f);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, 0.0f, 1.0f);
        glEnd();

        glPopMatrix();
    }
    
    public Texture getShadowMapTexture() {
    	return shadowMap.getDepthMapTexture();
    }

    @Override
    public void cleanup() {
    	if (shadowMap != null) {
            shadowMap.cleanup();
        }
        if (depthShaderProgram != null) {
            depthShaderProgram.cleanup();
        }
        if (skyBoxShaderProgram != null) {
            skyBoxShaderProgram.cleanup();
        }
        if (sceneShaderProgram != null) {
            sceneShaderProgram.cleanup();
        }
        if (hudShaderProgram != null) {
            hudShaderProgram.cleanup();
        }
    }
}
