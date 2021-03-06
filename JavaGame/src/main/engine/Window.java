package main.engine;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import org.lwjgl.glfw.*;
import org.lwjgl.nuklear.NkAllocator;
import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkDrawVertexLayoutElement;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.system.MemoryUtil.nmemAllocChecked;
import static org.lwjgl.system.MemoryUtil.nmemFree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joml.Matrix4f;

import static org.lwjgl.glfw.GLFWVulkan.glfwVulkanSupported;
import static org.lwjgl.nuklear.Nuklear.NK_FORMAT_COUNT;
import static org.lwjgl.nuklear.Nuklear.NK_FORMAT_FLOAT;
import static org.lwjgl.nuklear.Nuklear.NK_FORMAT_R8G8B8A8;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_BACKSPACE;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_COPY;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_CUT;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_DEL;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_DOWN;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_ENTER;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_LEFT;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_PASTE;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_RIGHT;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_SCROLL_DOWN;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_SCROLL_END;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_SCROLL_START;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_SCROLL_UP;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_SHIFT;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_TAB;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_TEXT_END;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_TEXT_LINE_END;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_TEXT_LINE_START;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_TEXT_REDO;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_TEXT_START;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_TEXT_UNDO;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_TEXT_WORD_LEFT;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_TEXT_WORD_RIGHT;
import static org.lwjgl.nuklear.Nuklear.NK_KEY_UP;
import static org.lwjgl.nuklear.Nuklear.NK_VERTEX_ATTRIBUTE_COUNT;
import static org.lwjgl.nuklear.Nuklear.NK_VERTEX_COLOR;
import static org.lwjgl.nuklear.Nuklear.NK_VERTEX_POSITION;
import static org.lwjgl.nuklear.Nuklear.NK_VERTEX_TEXCOORD;
import static org.lwjgl.nuklear.Nuklear.nk_input_key;
import static org.lwjgl.nuklear.Nuklear.nk_input_unicode;

public class Window {

    private final String title;
    
    private final List<Integer> codePointList;
    
    private final Map<Integer, Integer> keyMap;
    
    private final EngineProperties props = EngineProperties.INSTANCE;

    private int width;

    private int height;

    private long windowHandle;

    private boolean resized;

    private boolean vSync;
    
    private MouseInput mouseInput;
    
    private WindowOptions opts;
    
    private Matrix4f projectionMatrix;

    public Window(String title, int width, int height, boolean vSync, WindowOptions opts) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.vSync = vSync;
        this.resized = false;
        this.opts = opts;
        projectionMatrix = new Matrix4f();
        codePointList = new ArrayList<Integer>();
        keyMap = new HashMap<Integer, Integer>();
    }

    public void init(GLFWKeyCallbackI keyCallback) {
        if(opts.useVulkan) { // Use Vulkan
        	if (!glfwInit()) {
                throw new IllegalStateException("Unable to initialize GLFW");
            }

            if (!glfwVulkanSupported()) {
                throw new IllegalStateException("Cannot find a compatible Vulkan installable client driver (ICD)");
            }

            GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            width = vidMode.width();
            height = vidMode.height();
            //setResized(true);

            glfwDefaultWindowHints();
            glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API);
            glfwWindowHint(GLFW_MAXIMIZED, GLFW_FALSE);

            // Create the window
            windowHandle = glfwCreateWindow(width, height, title + ": Vulkan", MemoryUtil.NULL, MemoryUtil.NULL);
            if (windowHandle == MemoryUtil.NULL) {
                throw new RuntimeException("Failed to create the GLFW window");
            }

            glfwSetFramebufferSizeCallback(windowHandle, (window, width, height) -> resize(width, height));

            glfwSetKeyCallback(windowHandle, (window, key, scancode, action, mods) -> {
                if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                    glfwSetWindowShouldClose(window, true);
                }
                if (keyCallback != null) {
                    keyCallback.invoke(window, key, scancode, action, mods);
                }
            });
        } else { // Use OpenGL
        	// Setup an error callback. The default implementation
            // will print the error message in System.err.
            GLFWErrorCallback.createPrint(System.err).set();

            // Initialize GLFW. Most GLFW functions will not work before doing this.
            if (!glfwInit()) {
                throw new IllegalStateException("Unable to initialize GLFW");
            }

            glfwDefaultWindowHints(); // optional, the current window hints are already the default
            glfwWindowHint(GLFW_VISIBLE, GL_FALSE); // the window will stay hidden after creation
            glfwWindowHint(GLFW_RESIZABLE, GL_TRUE); // the window will be resizable
            glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
            glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
            glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
            glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
            
            boolean maximized = false;
            // If no size has been specified set it to maximized state
            if (width == 0 || height == 0) {
                // Set up a fixed width and height so window initialization does not fail
            	GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
                width = vidmode.width();
                height = vidmode.height();
                glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);
                maximized = true;
            }

            // Create the window
            windowHandle = glfwCreateWindow(width, height, title + ": OpenGL", NULL, NULL);
            if (windowHandle == NULL) {
                throw new RuntimeException("Failed to create the GLFW window");
            }

            // Setup resize callback
            glfwSetFramebufferSizeCallback(windowHandle, (window, width, height) -> {
                this.width = width;
                this.height = height;
                this.setResized(true);
            });

            glfwSetCharCallback(windowHandle, (window, codepoint) -> {
            		codePointList.add(codepoint);
            	});
            // Setup a key callback. It will be called every time a key is pressed, repeated or released.
            glfwSetKeyCallback(windowHandle, (window, key, scancode, action, mods) -> {
                if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                    glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
                }
                if (keyCallback != null) {
                    keyCallback.invoke(window, key, scancode, action, mods);
                }
                keyMap.put(key, action);
            });

            if (maximized) {
                glfwMaximizeWindow(windowHandle);
            } else {
                // Get the resolution of the primary monitor
                GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
                // Center our window
                glfwSetWindowPos(
                        windowHandle,
                        (vidmode.width() - width) / 2,
                        (vidmode.height() - height) / 2
                );
            }

            // Make the OpenGL context current
            glfwMakeContextCurrent(windowHandle);

            if (isvSync()) {
                // Enable v-sync
                glfwSwapInterval(1);
            }

            // Make the window visible
            glfwShowWindow(windowHandle);

            GL.createCapabilities();

            // Set the clear color
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            
            //	Test For Depth
            glEnable(GL_DEPTH_TEST);
            glEnable(GL_STENCIL_TEST);
            if (opts.showTriangles) {
                glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
            }
            
            // Support for transparencies
            glEnable(GL_BLEND);
            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            
            if (opts.cullFace) {
                glEnable(GL_CULL_FACE);
                glCullFace(GL_BACK);
            }
        }
        updateProjectionMatrix();
        mouseInput = new MouseInput(windowHandle);
    }
    
    public void restoreState() {
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_STENCIL_TEST);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        if (opts.cullFace) {
            glEnable(GL_CULL_FACE);
            glCullFace(GL_BACK);
        }
    }
    
    public long getWindowHandle() {
        return windowHandle;
    }

    public void setClearColor(float r, float g, float b, float alpha) {
        glClearColor(r, g, b, alpha);
    }
    
    public List<Integer> getCodepointList() {
    	return codePointList;
    }
    
    public Map<Integer, Integer> getKeyMap() {
    	return keyMap;
    }
    
    public void clearCodepointList() {
    	codePointList.clear();
    }
    
    public void clearKeyMap() {
    	keyMap.clear();
    }
    
    public int getKey(int keyCode) {
    	return glfwGetKey(windowHandle, keyCode);
    }

    public boolean isKeyPressed(int keyCode) {
        return glfwGetKey(windowHandle, keyCode) == GLFW_PRESS;
    }

    public boolean windowShouldClose() {
        return glfwWindowShouldClose(windowHandle);
    }
    
    public Matrix4f getProjectionMatrix() {
        return projectionMatrix;
    }

    public Matrix4f updateProjectionMatrix() {
        float aspectRatio = (float) width / (float) height;
        return projectionMatrix.setPerspective(props.getFOV(), aspectRatio, props.getZNear(), props.getZFar());
    }

    public String getTitle() {
        return title;
    }
    
    public void setWindowTitle(String title) {
        glfwSetWindowTitle(windowHandle, title);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public MouseInput getMouseInput() {
        return mouseInput;
    }
    
    public void pollEvents() {
        glfwPollEvents();
        mouseInput.input();
    }
    
    public void swapBuffers() {
    	glfwSwapBuffers(windowHandle);
    }

    public boolean isResized() {
        return resized;
    }

    public void setResized(boolean resized) {
        this.resized = resized;
    }
    
    public void resize(int width, int height) {
        resized = true;
        this.width = width;
        this.height = height;
    }

    public boolean isvSync() {
        return vSync;
    }

    public void setvSync(boolean vSync) {
        this.vSync = vSync;
    }

    public void update() {
        glfwSwapBuffers(windowHandle);
        glfwPollEvents();
    }
    
    public void cleanup() {
        glfwFreeCallbacks(windowHandle);
        glfwDestroyWindow(windowHandle);
        glfwTerminate();
    }
    
    public WindowOptions getOptions() {
        return opts;
    }
    
    public static class WindowOptions {

        public boolean cullFace;

        public boolean showTriangles;
        
        public boolean showFps;

        public boolean useVulkan;
        
        public boolean compatibleProfile;
        
        public boolean antialiasing;

        public boolean frustumCulling;    
    }
}
