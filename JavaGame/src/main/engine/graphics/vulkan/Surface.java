package main.engine.graphics.vulkan;

import org.lwjgl.glfw.GLFWVulkan;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.KHRSurface;

import java.nio.LongBuffer;

public class Surface {
    private final PhysicalDevice physicalDevice;
    private final long vkSurface;

    public Surface(PhysicalDevice physicalDevice, long windowHandle) {
        this.physicalDevice = physicalDevice;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            LongBuffer pSurface = stack.mallocLong(1);
            GLFWVulkan.glfwCreateWindowSurface(this.physicalDevice.getVkPhysicalDevice().getInstance(), windowHandle,
                    null, pSurface);
            vkSurface = pSurface.get(0);
        }
    }

    public void cleanup() {
        KHRSurface.vkDestroySurfaceKHR(physicalDevice.getVkPhysicalDevice().getInstance(), vkSurface, null);
    }

    public long getVkSurface() {
        return vkSurface;
    }
}