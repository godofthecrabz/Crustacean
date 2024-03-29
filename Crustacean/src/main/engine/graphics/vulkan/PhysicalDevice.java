package main.engine.graphics.vulkan;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.*;
import org.tinylog.Logger;

import java.nio.IntBuffer;
import java.util.*;

import static org.lwjgl.vulkan.VK11.*;

public class PhysicalDevice {

    private final VkExtensionProperties.Buffer vkDeviceExtensions;
    private final VkPhysicalDeviceMemoryProperties vkMemoryProperties;
    private final VkPhysicalDevice vkPhysicalDevice;
    private final VkPhysicalDeviceFeatures vkPhysicalDeviceFeatures;
    private final VkPhysicalDeviceProperties vkPhysicalDeviceProperties;
    private final VkQueueFamilyProperties.Buffer vkQueueFamilyProps;
    private Set<Integer> suportedSampleCount;

    private PhysicalDevice(VkPhysicalDevice vkPhysicalDevice) {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            this.vkPhysicalDevice = vkPhysicalDevice;

            IntBuffer intBuffer = stack.mallocInt(1);

            // Get device properties
            vkPhysicalDeviceProperties = VkPhysicalDeviceProperties.calloc();
            vkGetPhysicalDeviceProperties(vkPhysicalDevice, vkPhysicalDeviceProperties);

            // Get device extensions
            VulkanUtils.vkCheck(vkEnumerateDeviceExtensionProperties(vkPhysicalDevice, (String) null, intBuffer, null),
                    "Failed to get number of device extension properties");
            vkDeviceExtensions = VkExtensionProperties.calloc(intBuffer.get(0));
            VulkanUtils.vkCheck(vkEnumerateDeviceExtensionProperties(vkPhysicalDevice, (String) null, intBuffer, vkDeviceExtensions),
                    "Failed to get extension properties");
            
            suportedSampleCount = calSupportedSampleCount(vkPhysicalDeviceProperties);

            // Get Queue family properties
            vkGetPhysicalDeviceQueueFamilyProperties(vkPhysicalDevice, intBuffer, null);
            vkQueueFamilyProps = VkQueueFamilyProperties.calloc(intBuffer.get(0));
            vkGetPhysicalDeviceQueueFamilyProperties(vkPhysicalDevice, intBuffer, vkQueueFamilyProps);

            vkPhysicalDeviceFeatures = VkPhysicalDeviceFeatures.calloc();
            vkGetPhysicalDeviceFeatures(vkPhysicalDevice, vkPhysicalDeviceFeatures);

            // Get Memory information and properties
            vkMemoryProperties = VkPhysicalDeviceMemoryProperties.calloc();
            vkGetPhysicalDeviceMemoryProperties(vkPhysicalDevice, vkMemoryProperties);
        }
    }

    public static PhysicalDevice createPhysicalDevice(Instance instance, String prefferredDeviceName) {
    	Logger.debug("Selecting physical devices");
    	PhysicalDevice selectedPhysicalDevice = null;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            // Get available devices
            PointerBuffer pPhysicalDevices = getPhysicalDevices(instance, stack);
            int numDevices = pPhysicalDevices != null ? pPhysicalDevices.capacity() : 0;
            if (numDevices <= 0) {
                throw new RuntimeException("No physical devices found");
            }

            // Populate available devices
            List<PhysicalDevice> devices = new ArrayList<>();
            List<PhysicalDevice> discreteDevices = new ArrayList<>();
            for (int i = 0; i < numDevices; i++) {
                VkPhysicalDevice vkPhysicalDevice = new VkPhysicalDevice(pPhysicalDevices.get(i), instance.getVkInstance());
                PhysicalDevice physicalDevice = new PhysicalDevice(vkPhysicalDevice);
                VkPhysicalDeviceProperties physicalDeviceProperties = physicalDevice.getVkPhysicalDeviceProperties();

                String deviceName = physicalDevice.getDeviceName();
                if (physicalDevice.hasGraphicsQueueFamily() && physicalDevice.hasKHRSwapChainExtension()) {
                    switch (physicalDeviceProperties.deviceType()) {
                        case VK_PHYSICAL_DEVICE_TYPE_DISCRETE_GPU -> {
                            Logger.debug("Discrete Device [{}] supports required extensions", deviceName);
                            if (prefferredDeviceName != null && prefferredDeviceName.equals(deviceName)) {
                                selectedPhysicalDevice = physicalDevice;
                            } else {
                                discreteDevices.add(physicalDevice);
                            }
                        }
                        case VK_PHYSICAL_DEVICE_TYPE_INTEGRATED_GPU -> {
                            Logger.debug("Integrated Device [{}] supports required extensions", deviceName);
                            if (prefferredDeviceName != null && prefferredDeviceName.equals(deviceName)) {
                                selectedPhysicalDevice = physicalDevice;
                            } else {
                                devices.add(physicalDevice);
                            }
                        }
                        default -> {
                            Logger.debug("Device [{}] supports required extensions but is unrecognized type", deviceName);
                            if (prefferredDeviceName != null && prefferredDeviceName.equals(deviceName)) {
                                selectedPhysicalDevice = physicalDevice;
                            }
                        }
                    }
                } else {
                	Logger.debug("Device [{}] does not support required extensions", deviceName);
                    physicalDevice.cleanup();
                }
            }

            selectedPhysicalDevice = selectedPhysicalDevice == null && !discreteDevices.isEmpty() ? discreteDevices.remove(0) : selectedPhysicalDevice;
            // No preferred device or it does not meet requirements, just pick the first one
            selectedPhysicalDevice = selectedPhysicalDevice == null && !devices.isEmpty() ? devices.remove(0) : selectedPhysicalDevice;

            // Clean up non-selected devices
            for (PhysicalDevice physicalDevice : devices) {
                physicalDevice.cleanup();
            }
            for (PhysicalDevice physicalDevice : discreteDevices) {
                physicalDevice.cleanup();
            }

            if (selectedPhysicalDevice == null) {
                throw new RuntimeException("No suitable physical devices found");
            }
            Logger.debug("Selected device: [{}]", selectedPhysicalDevice.getDeviceName());
        }

        return selectedPhysicalDevice;
    }

    protected static PointerBuffer getPhysicalDevices(Instance instance, MemoryStack stack) {
        PointerBuffer pPhysicalDevices;
        // Get number of physical devices
        IntBuffer intBuffer = stack.mallocInt(1);
        VulkanUtils.vkCheck(vkEnumeratePhysicalDevices(instance.getVkInstance(), intBuffer, null),
                "Failed to get number of physical devices");
        int numDevices = intBuffer.get(0);
        Logger.debug("Detected {} physical device(s)", numDevices);

        // Populate physical devices list pointer
        pPhysicalDevices = stack.mallocPointer(numDevices);
        VulkanUtils.vkCheck(vkEnumeratePhysicalDevices(instance.getVkInstance(), intBuffer, pPhysicalDevices),
                "Failed to get physical devices");
        return pPhysicalDevices;
    }
    
    private Set<Integer> calSupportedSampleCount(VkPhysicalDeviceProperties devProps) {
        Set<Integer> result = new HashSet<>();
        long colorCounts = Integer.toUnsignedLong(vkPhysicalDeviceProperties.limits().framebufferColorSampleCounts());
        Logger.debug("Color max samples: {}", colorCounts);
        long depthCounts = Integer.toUnsignedLong(devProps.limits().framebufferDepthSampleCounts());
        Logger.debug("Depth max samples: {}", depthCounts);
        int counts = (int) (Math.min(colorCounts, depthCounts));
        Logger.debug("Max samples: {}", depthCounts);

        result.add(VK_SAMPLE_COUNT_1_BIT);
        if ((counts & VK_SAMPLE_COUNT_64_BIT) > 0) {
            result.add(VK_SAMPLE_COUNT_64_BIT);
        }
        if ((counts & VK_SAMPLE_COUNT_32_BIT) > 0) {
            result.add(VK_SAMPLE_COUNT_32_BIT);
        }
        if ((counts & VK_SAMPLE_COUNT_16_BIT) > 0) {
            result.add(VK_SAMPLE_COUNT_16_BIT);
        }
        if ((counts & VK_SAMPLE_COUNT_8_BIT) > 0) {
            result.add(VK_SAMPLE_COUNT_8_BIT);
        }
        if ((counts & VK_SAMPLE_COUNT_4_BIT) > 0) {
            result.add(VK_SAMPLE_COUNT_4_BIT);
        }
        if ((counts & VK_SAMPLE_COUNT_2_BIT) != 0) {
            result.add(VK_SAMPLE_COUNT_2_BIT);
        }

        return result;
    }

    public void cleanup() {
    	if (Logger.isDebugEnabled()) {
            Logger.debug("Destroying physical device [{}]", vkPhysicalDeviceProperties.deviceNameString());
        }
        vkMemoryProperties.free();
        vkPhysicalDeviceFeatures.free();
        vkQueueFamilyProps.free();
        vkDeviceExtensions.free();
        vkPhysicalDeviceProperties.free();
    }

    public String getDeviceName() {
        return vkPhysicalDeviceProperties.deviceNameString();
    }

    public VkPhysicalDeviceMemoryProperties getVkMemoryProperties() {
        return vkMemoryProperties;
    }

    public VkPhysicalDevice getVkPhysicalDevice() {
        return vkPhysicalDevice;
    }

    public VkPhysicalDeviceFeatures getVkPhysicalDeviceFeatures() {
        return vkPhysicalDeviceFeatures;
    }

    public VkPhysicalDeviceProperties getVkPhysicalDeviceProperties() {
        return vkPhysicalDeviceProperties;
    }

    public VkQueueFamilyProperties.Buffer getVkQueueFamilyProps() {
        return vkQueueFamilyProps;
    }

    private boolean hasGraphicsQueueFamily() {
        boolean result = false;
        int numQueueFamilies = vkQueueFamilyProps != null ? vkQueueFamilyProps.capacity() : 0;
        for (int i = 0; i < numQueueFamilies; i++) {
            VkQueueFamilyProperties familyProps = vkQueueFamilyProps.get(i);
            if ((familyProps.queueFlags() & VK_QUEUE_GRAPHICS_BIT) != 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean hasKHRSwapChainExtension() {
        boolean result = false;
        int numExtensions = vkDeviceExtensions != null ? vkDeviceExtensions.capacity() : 0;
        for (int i = 0; i < numExtensions; i++) {
            String extensionName = vkDeviceExtensions.get(i).extensionNameString();
            if (KHRSwapchain.VK_KHR_SWAPCHAIN_EXTENSION_NAME.equals(extensionName)) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    public boolean supportsSampleCount(int numSamples) {
        return suportedSampleCount.contains(numSamples);
    }
}