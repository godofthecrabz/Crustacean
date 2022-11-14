package main.game;

import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;
import java.util.List;

import main.engine.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import main.engine.graphics.ModelData;
import main.engine.graphics.animation.AnimGameItem;
import main.engine.graphics.camera.Camera;
import main.engine.graphics.camera.MouseBoxSelectionDetector;
import main.engine.graphics.hud.GameMenu;
import main.engine.graphics.hud.NKHudElement;
import main.engine.graphics.lights.DirectionalLight;
import main.engine.graphics.lights.Light;
import main.engine.graphics.particles.FlowParticleEmitter;
import main.engine.graphics.vulkan.VKRenderer;
import main.engine.items.GameItem;
import main.engine.items.SkyBox;
import main.engine.loaders.assimp.ModelLoader;
import main.engine.physics.Physics;
import main.engine.scene.Level;
import main.engine.scene.Scene;
import main.engine.scene.SceneLight;
import main.engine.sound.SoundBuffer;
import main.engine.sound.SoundListener;
import main.engine.sound.SoundManager;
import main.engine.sound.SoundSource;
import main.engine.utility.ResourcePaths;

import crab.newton.*;
import org.tinylog.Logger;
import java.lang.foreign.*;

public class Game implements IGameLogic {
	
	private static final EngineProperties engineProperties = EngineProperties.INSTANCE;
	
	private static final float MOUSE_SENSITIVITY = 0.2f;

    private final Vector3f cameraInc;
    
    private final Camera camera;

    private Scene scene;
    
    //private GameHud gHud;

    private float lightAngle;
    
    private static final float CAMERA_POS_STEP = 0.05f;
    
    private float angleInc;
    
    private Light directionalLight;
    
    private final SoundManager soundMgr;
    
    private FlowParticleEmitter particleEmitter;
    
    private MouseBoxSelectionDetector selectDetector;
    
    private boolean leftButtonPressed;
    
    private boolean firstTime;

    private boolean sceneChanged;
    
    private boolean updatePhysics;
    
    private enum Sounds { FIRE };
    
    private GameItem[] gameItems;
    
    private GameItem bob, monster;
    
    private SkyBox skybox;
    
    private NewtonBody cubeBody;
    
    private AnimGameItem momster;
    
    private Vector3f rotatingAngle = new Vector3f(1, 1, 1);
    
    private VKRenderer vkRenderer;

    private MemorySession gameSession;
    
    private NewtonWorld world;
    
    private final Level[] levels;
    
    private Physics gamePhysics;
    
    private GameMenu menu;
    private GameMenu.Level currentLevel;
    
    private boolean shouldShow;

    private int levelSelection;
    
    public Game() {
        camera = new Camera();
        soundMgr = new SoundManager();
        cameraInc = new Vector3f(0.0f, 0.0f, 0.0f);
        angleInc = 0;
        lightAngle = 45;
        firstTime = true;
        levels = new Level[2];
        levelSelection = 1;
    }
    
    public static void main(String[] args) {
        try {
            IGameLogic gameLogic = new Game();
            Window.WindowOptions opts = new Window.WindowOptions();
            opts.showFps = true;
            opts.compatibleProfile = true;
            opts.frustumCulling = true;
            GameEngine gameEng = new GameEngine("GAME", opts, gameLogic);
            gameEng.start();
        } catch (Exception excp) {
            excp.printStackTrace();
            System.exit(-1);
        }
    }
    
    @Override
    public void init(Window window, Scene scene, VKRenderer renderer) throws Exception {
        soundMgr.init();
        
        leftButtonPressed = false;

        gameSession = MemorySession.openShared();
        Newton.loadNewton("C:\\Users\\Christopher\\Documents\\Workspace\\Crustacean\\resources\\newtondll\\newton.dll", gameSession);
        /*
        try {
            Newton.loadNewton();
            Logger.debug("Loaded Newton in Jar");
        } catch (IOException e) {
            Newton.loadNewton("C:\\Users\\Christopher\\Documents\\Workspace\\Crustacean\\resources\\newtondll\\newton.dll");
            Logger.debug("Loaded Newton Absolutely");
        }
        */
        world = NewtonWorld.create();
        
        this.scene = scene;
        
        vkRenderer = renderer;
        
        gamePhysics = new Physics();

        levels[0] = new NewtonDemo(world, gamePhysics, gameSession);
        levels[1] = new Sponza();
    	
        levels[levelSelection].load(scene, renderer, world, gamePhysics, gameSession);
        
        if (levelSelection != 0) {
            bob = scene.getGameItemsByModelId("bob-model").get(0);
            monster = scene.getGameItemsByModelId("monster-model").get(0);
        }
        
        String skyboxId = "skyboxModel";
        ModelData skyboxModel = ModelLoader.loadModel(skyboxId, ResourcePaths.Models.SKYBOX_OBJ, 
        		ResourcePaths.Textures.TEXTURE_DIR, false);
        skyboxModel.getMaterialList().set(0, new ModelData.Material(ResourcePaths.Textures.SKYBOX_TEXTURE));
        skybox = new SkyBox(skyboxModel, window, scene, vkRenderer);
        skybox.setScale(200f);
        skybox.buildModelMatrix();
        scene.setSkyBox(skybox);
        renderer.loadSkyBox(skyboxModel, scene);
        
        menu = new GameMenu(window);
        currentLevel = GameMenu.Level.SPONZA;
        vkRenderer.setNulkearElements(new NKHudElement[] {menu});
        shouldShow = true;
        
        camera.setPosition(-6.0f, 2.0f, 0.0f);
        camera.setRotationEuler((float) Math.toRadians(20.0f), (float) Math.toRadians(90.f), 0.0f);
        scene.setCamera(camera);
        
        scene.getSceneLight().getAmbientLight().set(0.2f, 0.2f, 0.2f, 1.0f);
        List<Light> lights = new ArrayList<>();
        directionalLight = new Light();
        directionalLight.getPosition().set(0.0f, 1.0f, 0.0f, 0.0f);
        directionalLight.getColor().set(1.0f, 1.0f, 1.0f, 1.0f);
        lights.add(directionalLight);
        updateDirectionalLight();
        
        Light[] lightArr = new Light[lights.size()];
        lightArr = lights.toArray(lightArr);
        scene.getSceneLight().setLights(lightArr);
    }
    
    private void setupSounds() throws Exception {
        SoundBuffer buffFire = new SoundBuffer(ResourcePaths.Sounds.FIRE_OGG);
        soundMgr.addSoundBuffer(buffFire);
        SoundSource sourceFire = new SoundSource(true, false);
        Vector3f pos = particleEmitter.getBaseParticle().getPosition();
        sourceFire.setPosition(pos);
        sourceFire.setBuffer(buffFire.getBufferId());
        soundMgr.addSoundSource(Sounds.FIRE.toString(), sourceFire);
        sourceFire.play();
        
        soundMgr.setListener(new SoundListener(new Vector3f()));      
    }
    
    private void setupLights() {
        SceneLight sceneLight = new SceneLight();
        scene.setSceneLight(sceneLight);

        // Ambient Light
        //sceneLight.setAmbientLight(new Vector3f(0.3f, 0.3f, 0.3f));
        sceneLight.getSkyBoxLight().set(new Vector3f(1.0f, 1.0f, 1.0f));

        // Directional Light
        float lightIntensity = 1.0f;
        Vector3f lightDirection = new Vector3f(0, 1, 1);
        DirectionalLight directionalLight = new DirectionalLight(new Vector3f(1, 1, 1), lightDirection, lightIntensity);
        directionalLight.setShadowPosMult(5);
        directionalLight.setOrthoCords(-10.0f, 10.0f, -10.0f, 10.0f, -1.0f, 20.0f);
        //sceneLight.setDirectionalLight(directionalLight);
    }

    @Override
    public void inputAndUpdate(Window window, Scene scene, long diffTimeNanos) throws Exception {
        if (!currentLevel.equals(menu.getLevel())) {
            currentLevel = menu.getLevel();
            switch (currentLevel) {
                case SPONZA -> {
                    levelSelection = 1;
                    vkRenderer.unloadModels();
                    scene.removeAllGameItems();
                    levels[levelSelection].load(scene, vkRenderer, world, gamePhysics, gameSession);
                    bob = scene.getGameItemsByModelId("bob-model").get(0);
                    monster = scene.getGameItemsByModelId("monster-model").get(0);
                }
                case NEWTONDEMO -> {
                    levelSelection = 0;
                    scene.removeAllGameItems();
                    vkRenderer.unloadModels();
                    levels[levelSelection].load(scene, vkRenderer, world, gamePhysics, gameSession);
                }
            }
        }
    	sceneChanged = false;
    	cameraInc.set(0, 0, 0);
        KeyboardInput keyboard = window.getKeyboardInput();
    	if (keyboard.isKeyPressedOnce(GLFW_KEY_ESCAPE)) {
            Logger.debug("Escape key pressed");
    		menu.showWindow(shouldShow);
    		shouldShow = !shouldShow;
    	}
        if (keyboard.isKeyPressed(GLFW_KEY_W)) {
            cameraInc.z = -1;
            sceneChanged = true;
        } else if (keyboard.isKeyPressed(GLFW_KEY_S)) {
            cameraInc.z = 1;
            sceneChanged = true;
        }
        if (keyboard.isKeyPressed(GLFW_KEY_A)) {
            cameraInc.x = -1;
            sceneChanged = true;
        } else if (keyboard.isKeyPressed(GLFW_KEY_D)) {
            cameraInc.x = 1;
            sceneChanged = true;
        }
        if (keyboard.isKeyPressed(GLFW_KEY_Z)) {
            cameraInc.y = -1;
            sceneChanged = true;
        } else if (keyboard.isKeyPressed(GLFW_KEY_X)) {
            cameraInc.y = 1;
            sceneChanged = true;
        }
        
        if (keyboard.isKeyPressed(GLFW_KEY_LEFT)) {
            angleInc -= 0.05f;
            scene.getSceneLight().setLightChanged(true);
        } else if (keyboard.isKeyPressed(GLFW_KEY_RIGHT)) {
            angleInc += 0.05f;
            scene.getSceneLight().setLightChanged(true);
        } else {
            angleInc = 0;
            scene.getSceneLight().setLightChanged(false);
        }
        
        if (keyboard.isKeyPressed(GLFW_KEY_SPACE) && levelSelection != 0) {
            bob.getGameItemAnimation().setStarted(!bob.getGameItemAnimation().isStarted());
            monster.getGameItemAnimation().setStarted(!monster.getGameItemAnimation().isStarted());
        }
        
        if (keyboard.isKeyPressed(GLFW_KEY_F) && levelSelection == 0) {
        	updatePhysics = true;
        } else {
        	updatePhysics = false;
        }
        
        lightAngle += angleInc;
        if (lightAngle < 0) {
            lightAngle = 0;
        } else if (lightAngle > 180) {
            lightAngle = 180;
        }
        updateDirectionalLight();
        /**/
        if (levelSelection != 0) {
            GameItem.GameItemAnimation itemAnimation = bob.getGameItemAnimation();
            if (itemAnimation.isStarted()) {
                int currentFrame = Math.floorMod(itemAnimation.getCurrentFrame() + 1, itemAnimation.maxFrames);
                itemAnimation.setCurrentFrame(currentFrame);
            }

            itemAnimation = monster.getGameItemAnimation();
            if (itemAnimation.isStarted()) {
                int currentFrame = Math.floorMod(itemAnimation.getCurrentFrame() + 1, itemAnimation.maxFrames);
                itemAnimation.setCurrentFrame(currentFrame);
            }
        }
        
        if (updatePhysics) {
        	float diffTimeSeconds = (float) (diffTimeNanos / 1000000000f); //1000000000f
    		world.update(diffTimeSeconds);
        	gamePhysics.update(diffTimeSeconds);
    	}
    	MouseInput mouseInput = window.getMouseInput();
    	// Update camera based on mouse            
        if (mouseInput.isRightButtonPressed()) {
            Vector2f rotVec = mouseInput.getDisplVec();
            camera.moveRotation(rotVec.x * MOUSE_SENSITIVITY, rotVec.y * MOUSE_SENSITIVITY, 0);
            sceneChanged = true;
        }
        
        // Update camera position
        Vector3f prevPos = new Vector3f(camera.getPosition());
        camera.movePosition(cameraInc.x * CAMERA_POS_STEP, cameraInc.y * CAMERA_POS_STEP, cameraInc.z * CAMERA_POS_STEP);        
        // Check if there has been a collision. If true, set the y position to
        // the maximum height
        float height = -Float.MAX_VALUE;
        if ( camera.getPosition().y <= height )  {
            camera.setPosition(prevPos.x, prevPos.y, prevPos.z);
        }
        
        camera.updateViewMatrixQuat();
    }

    @Override
    public void cleanup() {
    	if (vkRenderer != null) {
    		vkRenderer.cleanup();
    	}
    	soundMgr.cleanup();
        scene.cleanup();
        /*
        if ( gHud != null ) {
            gHud.cleanup();
        }*/
        if (world != null) {
            world.destroy();
        }
        if (gameSession.isAlive()) {
            gameSession.close();
        }
        Newton.unloadNewton();
    }
    
    private void updateDirectionalLight() {
        float zValue = (float) Math.cos(Math.toRadians(lightAngle));
        float yValue = (float) Math.sin(Math.toRadians(lightAngle));
        Vector4f lightDirection = directionalLight.getPosition();
        lightDirection.x = 0;
        lightDirection.y = yValue;
        lightDirection.z = zValue;
        lightDirection.normalize();
        lightDirection.w = 0.0f;
    }
}
