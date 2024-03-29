package main.engine.input;

import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_1;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_2;
import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_3;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.glfwGetMouseButton;
import static org.lwjgl.glfw.GLFW.glfwSetCursorEnterCallback;
import static org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback;
import static org.lwjgl.glfw.GLFW.glfwSetMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.glfwSetScrollCallback;

import java.util.HashMap;
import java.util.Map;

import org.joml.Vector2f;
import org.lwjgl.nuklear.NkContext;

public class MouseInput {

	private Vector2f currentPos;
	
    private Vector2f displVec;
    
    private boolean inWindow;
    
    private Vector2f previousPos;
    
    private boolean leftButtonPressed;
    
    private boolean rightButtonPressed;
    
    private boolean middleButtonPressed;
    
    private double xoffset, yoffset;
    
    private final long windowHandle;

    private final int[] buttonStates;
    
    public MouseInput(long windowHandle) {
        previousPos = new Vector2f(-1, -1);
        currentPos = new Vector2f();
        displVec = new Vector2f();
        leftButtonPressed = false;
        rightButtonPressed = false;
        inWindow = false;
        this.windowHandle = windowHandle;
        buttonStates = new int[8];

        glfwSetCursorPosCallback(windowHandle, (handle, xpos, ypos) -> {
            currentPos.x = (float) xpos;
            currentPos.y = (float) ypos;
        });
        glfwSetCursorEnterCallback(windowHandle, (handle, entered) -> inWindow = entered);
        glfwSetMouseButtonCallback(windowHandle, (handle, button, action, mode) -> {
            leftButtonPressed = button == GLFW_MOUSE_BUTTON_1 && action == GLFW_PRESS;
            rightButtonPressed = button == GLFW_MOUSE_BUTTON_2 && action == GLFW_PRESS;
            middleButtonPressed = button == GLFW_MOUSE_BUTTON_3 && action == GLFW_PRESS;
            buttonStates[button] = action;
        });
        glfwSetScrollCallback(windowHandle, (window, xoffset, yoffset) -> {
        	this.xoffset = xoffset;
        	this.yoffset = yoffset;
        });
    }
    
    public Vector2f getCurrentPos() {
        return currentPos;
    }
    
    public Vector2f getPreviousPos() {
    	return previousPos;
    }

    public Vector2f getDisplVec() {
        return displVec;
    }
    
    public double getXOffset() {
    	return xoffset;
    }
    
    public double getYOffset() {
    	return yoffset;
    }

    public void input() {
        displVec.x = 0;
        displVec.y = 0;
        if (previousPos.x > 0 && previousPos.y > 0 && inWindow) {
            double deltax = currentPos.x - previousPos.x;
            double deltay = currentPos.y - previousPos.y;
            boolean rotateX = deltax != 0;
            boolean rotateY = deltay != 0;
            if (rotateX) {
                displVec.y = (float) deltax;
            }
            if (rotateY) {
                displVec.x = (float) deltay;
            }
        }
        previousPos.x = currentPos.x;
        previousPos.y = currentPos.y;
    }
    
    public boolean isButtonPressed(int buttonCode) {
    	return glfwGetMouseButton(windowHandle, buttonCode) == GLFW_PRESS;
    }

    public boolean isLeftButtonPressed() {
        return leftButtonPressed;
    }
    
    public boolean isMiddleButtonPressed() {
    	return middleButtonPressed;
    }

    public boolean isRightButtonPressed() {
        return rightButtonPressed;
    }

    public int[] getButtonStates() {
        return buttonStates;
    }
}