package main.engine.graphics.camera;

import org.joml.primitives.Intersectionf;

import main.engine.items.GameItem;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class CameraBoxSelectionDetector {

    private final Vector3f max;

    private final Vector3f min;

    private final Vector2f nearFar;

    private Vector3f dir;

    public CameraBoxSelectionDetector() {
        dir = new Vector3f();
        min = new Vector3f();
        max = new Vector3f();
        nearFar = new Vector2f();
    }

    public void selectGameItem(GameItem[] gameItems, Camera camera) {        
        dir = camera.getViewMatrix().positiveZ(dir).negate();
        selectGameItem(gameItems, camera.getPosition(), dir);
    }
    
    protected boolean selectGameItem(GameItem[] gameItems, Vector3f center, Vector3f dir) {
    	boolean selected = false;
    	GameItem selectedGameItem = null;
        float closestDistance = Float.POSITIVE_INFINITY;

        /*
        for (GameItem gameItem : gameItems) {
            gameItem.setSelected(false);
            min.set(gameItem.getPosition());
            max.set(gameItem.getPosition());
            min.add(-gameItem.getScale().x, -gameItem.getScale().y, -gameItem.getScale().z);
            max.add(gameItem.getScale().x, gameItem.getScale().y, gameItem.getScale().z);
            if (Intersectionf.intersectRayAab(center, dir, min, max, nearFar) && nearFar.x < closestDistance) {
                closestDistance = nearFar.x;
                selectedGameItem = gameItem;
            }
        }

        if (selectedGameItem != null) {
            selectedGameItem.setSelected(true);
            selected = true;
        }*/
        return selected;
    }
}