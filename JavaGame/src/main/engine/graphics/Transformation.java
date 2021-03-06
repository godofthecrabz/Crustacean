package main.engine.graphics;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import main.engine.graphics.camera.Camera;
import main.engine.items.GameItem;

public class Transformation {

    private final Matrix4f projectionMatrix;
    
    private final Matrix4f modelMatrix;

    private final Matrix4f modelViewMatrix;
    
    private final Matrix4f modelLightViewMatrix;
    
    private final Matrix4f lightViewMatrix;
    
    private final Matrix4f orthoProjMatrix;

    private final Matrix4f ortho2DMatrix;

    private final Matrix4f orthoModelMatrix;
    
    private final Matrix4f localModelMatrix;
    
    private final Matrix4f forwardMatrix;
    
    public Transformation() {
    	projectionMatrix = new Matrix4f();
        modelMatrix = new Matrix4f();
        modelViewMatrix = new Matrix4f();
        modelLightViewMatrix = new Matrix4f();
        orthoProjMatrix = new Matrix4f();
        ortho2DMatrix = new Matrix4f();
        orthoModelMatrix = new Matrix4f();
        lightViewMatrix = new Matrix4f();
        localModelMatrix = new Matrix4f();
        forwardMatrix = new Matrix4f();
    }
    
    public Matrix4f getProjectionMatrix() {
        return projectionMatrix;
    }
    
    public Matrix4f updateProjectionMatrix(float fov, float width, float height, float zNear, float zFar) {
        projectionMatrix.identity();
        return projectionMatrix.setPerspective(fov, width / height, zNear, zFar);
    }
    
    public final Matrix4f getOrthoProjectionMatrix() {
        return orthoProjMatrix;
    }
    
    public Matrix4f updateOrthoProjectionMatrix(float left, float right, float bottom, float top, float zNear, float zFar) {
        orthoProjMatrix.identity();
        orthoProjMatrix.setOrtho(left, right, bottom, top, zNear, zFar);
        return orthoProjMatrix;
    }
    
    public Matrix4f getLightViewMatrix() {
        return lightViewMatrix;
    }

    public void setLightViewMatrix(Matrix4f lightViewMatrix) {
        this.lightViewMatrix.set(lightViewMatrix);
    }

    public Matrix4f updateLightViewMatrix(Vector3f position, Vector3f rotation) {
        return updateGenericViewMatrix(position, rotation, lightViewMatrix);
    }
    
    public static  Matrix4f updateGenericViewMatrix(Vector3f position, Vector3f rotation, Matrix4f matrix) {
        // First do the rotation so camera rotates over its position
        return matrix.rotationX((float)Math.toRadians(rotation.x))
                     .rotateY((float)Math.toRadians(rotation.y))
                     .translate(-position.x, -position.y, -position.z);
    }
    
    public static Matrix4f updateGenericViewMatrix(Vector3f position, Quaternionf rotation, Matrix4f matrix) {
    	return matrix.rotation(rotation)
    				 .translate(-position.x, -position.y, -position.z);
    }
    
    public final Matrix4f getOrtho2DProjectionMatrix(float left, float right, float bottom, float top) {
        ortho2DMatrix.identity();
        ortho2DMatrix.setOrtho2D(left, right, bottom, top);
        return ortho2DMatrix;
    }
    
    public Vector3f forward(GameItem gameItem) {
    	Vector3f forward = new Vector3f();
    	return forwardMatrix.rotation(gameItem.getRotation()).positiveZ(forward).negate();
    }
    
    public static Matrix4f buildLocalModelMatrix(GameItem gameItem, Matrix4f matrix) {
    	Quaternionf rotation = gameItem.getRotation();
    	return matrix.translationRotateScaleInvert(
    			gameItem.getPosition().x, gameItem.getPosition().y, gameItem.getPosition().z, 
    			rotation.x, rotation.y, rotation.z, rotation.w, 
    			gameItem.getScale().x, gameItem.getScale().y, gameItem.getScale().z);
    }
    
    public static Matrix4f buildModelMatrix(GameItem gameItem, Matrix4f matrix) {
    	Quaternionf rotation = gameItem.getRotation();
    	return matrix.translationRotateScale(
                gameItem.getPosition().x, gameItem.getPosition().y, gameItem.getPosition().z,
                rotation.x, rotation.y, rotation.z, rotation.w,
                gameItem.getScale().x, gameItem.getScale().y, gameItem.getScale().z);
    }
    
    public static Matrix4f buildModelMatrix(Vector3f position, Quaternionf rotation, Vector3f scale, Matrix4f matrix) {
    	return matrix.translationRotateScale(
                position.x, position.y, position.z,
                rotation.x, rotation.y, rotation.z, rotation.w,
                scale.x, scale.y, scale.z);
    }
    
    public Matrix4f buildModelViewMatrix(GameItem gameItem, Matrix4f viewMatrix) {
        return buildModelViewMatrix(buildModelMatrix(gameItem, modelMatrix), viewMatrix);
    }
    
    public Matrix4f buildModelViewMatrix(Matrix4f modelMatrix, Matrix4f viewMatrix) {
        return viewMatrix.mulAffine(modelMatrix, modelViewMatrix);
    }

    public Matrix4f buildModelLightViewMatrix(GameItem gameItem, Matrix4f lightViewMatrix) {
        return buildModelViewMatrix(buildModelMatrix(gameItem, modelMatrix), lightViewMatrix);
    }

    public Matrix4f buildModelLightViewMatrix(Matrix4f modelMatrix, Matrix4f lightViewMatrix) {
        return lightViewMatrix.mulAffine(modelMatrix, modelLightViewMatrix);
    }

    public Matrix4f buildOrthoProjModelMatrix(GameItem gameItem, Matrix4f orthoMatrix) {
        return orthoMatrix.mulOrthoAffine(buildModelMatrix(gameItem, modelMatrix), orthoModelMatrix);
    }
}