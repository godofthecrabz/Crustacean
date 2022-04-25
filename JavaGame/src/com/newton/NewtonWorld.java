package com.newton;

import jdk.incubator.foreign.*;

import org.joml.Vector3f;

import com.newton.generated.*;

public class NewtonWorld {
	
	protected final MemoryAddress address;
	protected final ResourceScope scope;
	
	private NewtonWorld(MemoryAddress address) {
		this.address = address;
		this.scope = ResourceScope.newConfinedScope();
	}
	
	public static NewtonWorld create() {
		return new NewtonWorld(Newton_h.NewtonCreate(new Object[] {}));
	}
	
	public static int getWorldVersion() {
		return Newton_h.NewtonWorldGetVersion(new Object[] {});
	}
	
	public static int getFloatSizes() {
		return Newton_h.NewtonWorldFloatSize(new Object[] {});
	}
	
	public static int getMemoryUsed() {
		return Newton_h.NewtonGetMemoryUsed(new Object[] {});
	}
	
	public static void setMemorySystem(NewtonAllocMemory alloc, NewtonFreeMemory free, ResourceScope scope) {
		NativeSymbol allocFunc = NewtonAllocMemory.allocate(alloc, scope);
		NativeSymbol freeFunc = NewtonFreeMemory.allocate(free, scope);
		Newton_h.NewtonSetMemorySystem(allocFunc, freeFunc);
	}
	
	public static MemoryAddress newtonAlloc(int sizeInBytes) {
		return Newton_h.NewtonAlloc(sizeInBytes);
	}
	
	public static MemorySegment newtonAlloc(int sizeInBytes, ResourceScope scope) {
		return MemorySegment.ofAddress(Newton_h.NewtonAlloc(sizeInBytes), sizeInBytes, scope);
	}
	
	public static MemoryAddress newtonAlloc(MemoryLayout layout) {
		return Newton_h.NewtonAlloc((int) layout.byteSize());
	}
	
	public static MemorySegment newtonAlloc(MemoryLayout layout, ResourceScope scope) {
		return MemorySegment.ofAddress(Newton_h.NewtonAlloc((int) layout.byteSize()), layout.byteSize(), scope);
	}
	
	public static void newtonFree(Addressable ptr) {
		Newton_h.NewtonFree(ptr);
	}
	
	public void destroy() {
		Newton_h.NewtonDestroy(address);
		if (scope.isAlive()) {
			scope.close();
		}
	}
	
	public NewtonPostUpdateCallback getPostUpdateCallback() {
		return NewtonPostUpdateCallback.ofAddress(Newton_h.NewtonGetPostUpdateCallback(address), scope);
	}
	
	public NewtonPostUpdateCallback getPostUpdateCallback(ResourceScope scope) {
		return NewtonPostUpdateCallback.ofAddress(Newton_h.NewtonGetPostUpdateCallback(address), scope);
	}
	
	public void setPostUpdateCallback(NewtonPostUpdateCallback callback) {
		NativeSymbol callbackFunc = NewtonPostUpdateCallback.allocate(callback, scope);
		Newton_h.NewtonSetPostUpdateCallback(address, callbackFunc);
	}
	
	public void setPostUpdateCallback(NewtonPostUpdateCallback callback, ResourceScope scope) {
		NativeSymbol callbackFunc = NewtonPostUpdateCallback.allocate(callback, scope);
		Newton_h.NewtonSetPostUpdateCallback(address, callbackFunc);
	}
	
	public void loadPlugins(String pluginPath) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment path = allocator.allocateUtf8String(pluginPath);
		Newton_h.NewtonLoadPlugins(address, path);
	}
	
	public void loadPlugins(String pluginPath, ResourceScope scope) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment path = allocator.allocateUtf8String(pluginPath);
		Newton_h.NewtonLoadPlugins(address, path);
	}
	
	public void loadPlugins(String pluginPath, SegmentAllocator allocator) {
		MemorySegment path = allocator.allocateUtf8String(pluginPath);
		Newton_h.NewtonLoadPlugins(address, path);
	}
	
	public void unloadPlugins() {
		Newton_h.NewtonUnloadPlugins(address);
	}
	
	public String currentPlugin() {
		MemoryAddress pluginStrAddress = Newton_h.NewtonCurrentPlugin(address);
		return pluginStrAddress.getUtf8String(0);
	}
	
	public String firstPlugin() {
		MemoryAddress pluginStrAddress = Newton_h.NewtonGetFirstPlugin(address);
		return pluginStrAddress.getUtf8String(0);
	}
	
	public String preferedPlugin() {
		MemoryAddress pluginStrAddress = Newton_h.NewtonGetPreferedPlugin(address);
		return pluginStrAddress.getUtf8String(0);
	}
	
	public float getContactMergeTolerance() {
		return Newton_h.NewtonGetContactMergeTolerance(address);
	}
	
	public void setContactMergeTolerance(float tolerance) {
		Newton_h.NewtonSetContactMergeTolerance(address, tolerance);
	}
	
	public void invalidateCache() {
		Newton_h.NewtonInvalidateCache(address);
	}
	
	public void setSolverIterations(int model) {
		Newton_h.NewtonSetSolverIterations(address, model);
	}
	
	public int getSolverIterations() {
		return Newton_h.NewtonGetSolverIterations(address);
	}
	
	public void setParallelSolverOnLargeIsland(int mode) {
		Newton_h.NewtonSetParallelSolverOnLargeIsland(address, mode);
	}
	
	public int getParallelSolverOnLargeIsland() {
		return Newton_h.NewtonGetParallelSolverOnLargeIsland(address);
	}
	
	public int getBroadphaseAlgorithm() {
		return Newton_h.NewtonGetBroadphaseAlgorithm(address);
	}
	
	public void selectBroadphaseAlgorithm(int algorithmType) {
		Newton_h.NewtonSelectBroadphaseAlgorithm(address, algorithmType);
	}
	
	public void resetBroadphase() {
		Newton_h.NewtonResetBroadphase(address);
	}
	
	public void update(float timestep) {
		Newton_h.NewtonUpdate(address, timestep);
	}
	
	public void updateAsync(float timestep) {
		Newton_h.NewtonUpdateAsync(address, timestep);
	}
	
	public void waitForUpdateToFinish() {
		Newton_h.NewtonWaitForUpdateToFinish(address);
	}
	
	public int getNumberOfSubsteps() {
		return Newton_h.NewtonGetNumberOfSubsteps(address);
	}
	
	public void setNumberOfSubsteps(int substeps) {
		Newton_h.NewtonSetNumberOfSubsteps(address, substeps);
	}
	
	public float getLastUpdateTime() {
		return Newton_h.NewtonGetLastUpdateTime(address);
	}
	
	public void serializeToFile(String filename, NewtonOnBodySerializationCallback bodyCallback, Addressable bodyUserData) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment filePath = allocator.allocateUtf8String(filename);
		NativeSymbol callbackFunc = NewtonOnBodySerializationCallback.allocate(bodyCallback, scope);
		Newton_h.NewtonSerializeToFile(address, filePath, callbackFunc, bodyUserData);
	}
	
	public void serializeToFile(String filename, NewtonOnBodySerializationCallback bodyCallback, Addressable bodyUserData,
			ResourceScope scope) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment filePath = allocator.allocateUtf8String(filename);
		NativeSymbol callbackFunc = NewtonOnBodySerializationCallback.allocate(bodyCallback, scope);
		Newton_h.NewtonSerializeToFile(address, filePath, callbackFunc, bodyUserData);
	}
	
	public void deserializeFromFile(String filename, NewtonOnBodyDeserializationCallback bodyCallback, Addressable bodyUserData) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment filePath = allocator.allocateUtf8String(filename);
		NativeSymbol callbackFunc = NewtonOnBodyDeserializationCallback.allocate(bodyCallback, scope);
		Newton_h.NewtonDeserializeFromFile(address, filePath, callbackFunc, bodyUserData);
	}
	
	public void deserializeFromFile(String filename, NewtonOnBodyDeserializationCallback bodyCallback, Addressable bodyUserData,
			ResourceScope scope) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment filePath = allocator.allocateUtf8String(filename);
		NativeSymbol callbackFunc = NewtonOnBodyDeserializationCallback.allocate(bodyCallback, scope);
		Newton_h.NewtonDeserializeFromFile(address, filePath, callbackFunc, bodyUserData);
	}
	
	public void serializeScene(NewtonOnBodySerializationCallback bodyCallback, Addressable bodyUserData, NewtonSerializeCallback serializeCallback, Addressable serializeHandle) {
		NativeSymbol bodyFunc = NewtonOnBodySerializationCallback.allocate(bodyCallback, scope);
		NativeSymbol serializeFunc = NewtonSerializeCallback.allocate(serializeCallback, scope);
		Newton_h.NewtonSerializeScene(address, bodyFunc, bodyUserData, serializeFunc, serializeHandle);
	}
	
	public void serializeScene(NewtonOnBodySerializationCallback bodyCallback, Addressable bodyUserData, NewtonSerializeCallback serializeCallback, Addressable serializeHandle,
			ResourceScope scope) {
		NativeSymbol bodyFunc = NewtonOnBodySerializationCallback.allocate(bodyCallback, scope);
		NativeSymbol serializeFunc = NewtonSerializeCallback.allocate(serializeCallback, scope);
		Newton_h.NewtonSerializeScene(address, bodyFunc, bodyUserData, serializeFunc, serializeHandle);
	}
	
	public void deserializeScene(NewtonOnBodyDeserializationCallback bodyCallback, Addressable bodyUserData, NewtonDeserializeCallback serializeCallback, Addressable serializeHandle) {
		NativeSymbol bodyFunc = NewtonOnBodyDeserializationCallback.allocate(bodyCallback, scope);
		NativeSymbol deserializeFunc = NewtonDeserializeCallback.allocate(serializeCallback, scope);
		Newton_h.NewtonDeserializeScene(address, bodyFunc, bodyUserData, deserializeFunc, serializeHandle);
	}
	
	public void deserializeScene(NewtonOnBodyDeserializationCallback bodyCallback, Addressable bodyUserData, NewtonDeserializeCallback serializeCallback, Addressable serializeHandle,
			ResourceScope scope) {
		NativeSymbol bodyFunc = NewtonOnBodyDeserializationCallback.allocate(bodyCallback, scope);
		NativeSymbol deserializeFunc = NewtonDeserializeCallback.allocate(serializeCallback, scope);
		Newton_h.NewtonDeserializeScene(address, bodyFunc, bodyUserData, deserializeFunc, serializeHandle);
	}
	
	public NewtonBody findSerializedBody(int bodySerializedID) {
		MemoryAddress body = Newton_h.NewtonFindSerializedBody(address, bodySerializedID);
		int bodyType = Newton_h.NewtonBodyGetType(body);
		switch (bodyType) {
			case 0:
				return new NewtonDynamicBody(body, scope);
			case 1:
				return new NewtonKinematicBody(body, scope);
			default:
				throw new RuntimeException("Error finding serialized body");
		}
	}
	
	public void setJointSerializationCallbacks(NewtonOnJointSerializationCallback serializeJoint, NewtonOnJointDeserializationCallback deserializeJoint) {
		NativeSymbol serializeFunc = NewtonOnJointSerializationCallback.allocate(serializeJoint, scope);
		NativeSymbol deserializeFunc = NewtonOnJointDeserializationCallback.allocate(deserializeJoint, scope);
		Newton_h.NewtonSetJointSerializationCallbacks(address, serializeFunc, deserializeFunc);
	}
	
	public void setJointSerializationCallbacks(NewtonOnJointSerializationCallback serializeJoint, NewtonOnJointDeserializationCallback deserializeJoint,
			ResourceScope scope) {
		NativeSymbol serializeFunc = NewtonOnJointSerializationCallback.allocate(serializeJoint, scope);
		NativeSymbol deserializeFunc = NewtonOnJointDeserializationCallback.allocate(deserializeJoint, scope);
		Newton_h.NewtonSetJointSerializationCallbacks(address, serializeFunc, deserializeFunc);
	}
	
	public JointSerializationCallbacks getJointSerializationCallbacks() {
		MemoryAddress serializePtr = MemoryAddress.NULL;
		MemoryAddress deserializePtr = MemoryAddress.NULL;
		Newton_h.NewtonGetJointSerializationCallbacks(address, serializePtr, deserializePtr);
		NewtonOnJointSerializationCallback serializeCallback = NewtonOnJointSerializationCallback.ofAddress(serializePtr, scope);
		NewtonOnJointDeserializationCallback deserializeCallback = NewtonOnJointDeserializationCallback.ofAddress(deserializePtr, scope);
		return new JointSerializationCallbacks(serializeCallback, deserializeCallback);
	}
	
	public JointSerializationCallbacks getJointSerializationCallbacks(ResourceScope scope) {
		MemoryAddress serializePtr = MemoryAddress.NULL;
		MemoryAddress deserializePtr = MemoryAddress.NULL;
		Newton_h.NewtonGetJointSerializationCallbacks(address, serializePtr, deserializePtr);
		NewtonOnJointSerializationCallback serializeCallback = NewtonOnJointSerializationCallback.ofAddress(serializePtr, scope);
		NewtonOnJointDeserializationCallback deserializeCallback = NewtonOnJointDeserializationCallback.ofAddress(deserializePtr, scope);
		return new JointSerializationCallbacks(serializeCallback, deserializeCallback);
	}
	
	public void lockCriticalSection(int threadIndex) {
		Newton_h.NewtonWorldCriticalSectionLock(address, threadIndex);
	}
	
	public void unlockCriticalSection() {
		Newton_h.NewtonWorldCriticalSectionUnlock(address);
	}
	
	public void setThreadCount(int threads) {
		Newton_h.NewtonSetThreadsCount(address, threads);
	}
	
	public int getThreadCount() {
		return Newton_h.NewtonGetThreadsCount(address);
	}
	
	public int getMaxThreadCount() {
		return Newton_h.NewtonGetMaxThreadsCount(address);
	}
	
	public void dispatchThreadJob(NewtonJobTask task, Addressable userData, String functionName) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment function_name = allocator.allocateUtf8String(functionName);
		NativeSymbol taskFunc = NewtonJobTask.allocate(task, scope);
		Newton_h.NewtonDispachThreadJob(address, taskFunc, userData, function_name);
	}
	
	public void dispatchThreadJob(NewtonJobTask task, Addressable userData, String functionName, ResourceScope scope) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment function_name = allocator.allocateUtf8String(functionName);
		NativeSymbol taskFunc = NewtonJobTask.allocate(task, scope);
		Newton_h.NewtonDispachThreadJob(address, taskFunc, userData, function_name);
	}
	
	public void syncThreadJobs() {
		Newton_h.NewtonSyncThreadJobs(address);
	}
	
	public void setIslandUpdateEvent(NewtonIslandUpdate islandUpdate) {
		NativeSymbol islandUpdateFunc = NewtonIslandUpdate.allocate(islandUpdate, scope);
		Newton_h.NewtonSetIslandUpdateEvent(address, islandUpdateFunc);
	}
	
	public void setIslandUpdateEvent(NewtonIslandUpdate islandUpdate, ResourceScope scope) {
		NativeSymbol islandUpdateFunc = NewtonIslandUpdate.allocate(islandUpdate, scope);
		Newton_h.NewtonSetIslandUpdateEvent(address, islandUpdateFunc);
	}
	
	public void forEachJoint(NewtonJointIterator callback, Addressable userData) {
		NativeSymbol callbackFunc = NewtonJointIterator.allocate(callback, scope);
		Newton_h.NewtonWorldForEachJointDo(address, callbackFunc, userData);
	}
	
	public void forEachJoint(NewtonJointIterator callback, Addressable userData, ResourceScope scope) {
		NativeSymbol callbackFunc = NewtonJointIterator.allocate(callback, scope);
		Newton_h.NewtonWorldForEachJointDo(address, callbackFunc, userData);
	}
	
	public void forEachBodyInAABB(float[] p0, float[] p1, NewtonBodyIterator callback, Addressable userData) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment p0Segment = allocator.allocateArray(Newton_h.C_FLOAT, p0);
		MemorySegment p1Segment = allocator.allocateArray(Newton_h.C_FLOAT, p1);
		NativeSymbol callbackFunc = NewtonBodyIterator.allocate(callback, scope);
		Newton_h.NewtonWorldForEachBodyInAABBDo(address, p0Segment, p1Segment, callbackFunc, userData);
	}
	
	public void forEachBodyInAABB(float[] p0, float[] p1, NewtonBodyIterator callback, Addressable userData, ResourceScope scope) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment p0Segment = allocator.allocateArray(Newton_h.C_FLOAT, p0);
		MemorySegment p1Segment = allocator.allocateArray(Newton_h.C_FLOAT, p1);
		NativeSymbol callbackFunc = NewtonBodyIterator.allocate(callback, scope);
		Newton_h.NewtonWorldForEachBodyInAABBDo(address, p0Segment, p1Segment, callbackFunc, userData);
	}
	
	public void forEachBodyInAABB(Vector3f p0, Vector3f p1, NewtonBodyIterator callback, Addressable userData) {
		float[] p0Arr = new float[] {p0.x, p0.y, p0.z};
		float[] p1Arr = new float[] {p1.x, p1.y, p1.z};
		forEachBodyInAABB(p0Arr, p1Arr, callback, userData);
	}
	
	public void forEachBodyInAABB(Vector3f p0, Vector3f p1, NewtonBodyIterator callback, Addressable userData, ResourceScope scope) {
		float[] p0Arr = new float[] {p0.x, p0.y, p0.z};
		float[] p1Arr = new float[] {p1.x, p1.y, p1.z};
		forEachBodyInAABB(p0Arr, p1Arr, callback, userData, scope);
	}
	
	public void setUserData(Addressable userData) {
		Newton_h.NewtonWorldSetUserData(address, userData);
	}
	
	public MemoryAddress getUserData() {
		return Newton_h.NewtonWorldGetUserData(address);
	}
	
	public MemoryAddress addListener(String nameId, Addressable listenerUserData) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment nameIdSegment = allocator.allocateUtf8String(nameId);
		return Newton_h.NewtonWorldAddListener(address, nameIdSegment, listenerUserData);
	}
	
	public MemoryAddress addListener(String nameId, Addressable listenerUserData, ResourceScope scope) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment nameIdSegment = allocator.allocateUtf8String(nameId);
		return Newton_h.NewtonWorldAddListener(address, nameIdSegment, listenerUserData);
	}
	
	public MemoryAddress getListener(String nameId) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment nameIdSegment = allocator.allocateUtf8String(nameId);
		return Newton_h.NewtonWorldGetListener(address, nameIdSegment);
	}
	
	public MemoryAddress getListener(String nameId, ResourceScope scope) {
		SegmentAllocator allocator = SegmentAllocator.nativeAllocator(scope);
		MemorySegment nameIdSegment = allocator.allocateUtf8String(nameId);
		return Newton_h.NewtonWorldGetListener(address, nameIdSegment);
	}
	
	public void listenerSetDebugCallback(Addressable listener, NewtonWorldListenerDebugCallback callback) {
		NativeSymbol callbackFunc = NewtonWorldListenerDebugCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetDebugCallback(address, listener, callbackFunc);
	}
	
	public void listenerSetDebugCallback(Addressable listener, NewtonWorldListenerDebugCallback callback, ResourceScope scope) {
		NativeSymbol callbackFunc = NewtonWorldListenerDebugCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetDebugCallback(address, listener, callbackFunc);
	}
	
	public void listenerSetPostStepCallback(Addressable listener, NewtonWorldUpdateListenerCallback callback) {
		NativeSymbol callbackFunc = NewtonWorldUpdateListenerCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetPostStepCallback(address, listener, callbackFunc);
	}
	
	public void listenerSetPostStepCallback(Addressable listener, NewtonWorldUpdateListenerCallback callback, ResourceScope scope) {
		NativeSymbol callbackFunc = NewtonWorldUpdateListenerCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetPostStepCallback(address, listener, callbackFunc);
	}
	
	public void listenerSetPreUpdateCallback(Addressable listener, NewtonWorldUpdateListenerCallback callback) {
		NativeSymbol callbackFunc = NewtonWorldUpdateListenerCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetPreUpdateCallback(address, listener, callbackFunc);
	}
	
	public void listenerSetPreUpdateCallback(Addressable listener, NewtonWorldUpdateListenerCallback callback, ResourceScope scope) {
		NativeSymbol callbackFunc = NewtonWorldUpdateListenerCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetPreUpdateCallback(address, listener, callbackFunc);
	}
	
	public void listenerSetPostUpdateCallback(Addressable listener, NewtonWorldUpdateListenerCallback callback) {
		NativeSymbol callbackFunc = NewtonWorldUpdateListenerCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetPostUpdateCallback(address, listener, callbackFunc);
	}
	
	public void listenerSetPostUpdateCallback(Addressable listener, NewtonWorldUpdateListenerCallback callback, ResourceScope scope) {
		NativeSymbol callbackFunc = NewtonWorldUpdateListenerCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetPostUpdateCallback(address, listener, callbackFunc);
	}
	
	public void listenerSetDestructorCallback(Addressable listener, NewtonWorldDestroyListenerCallback callback) {
		NativeSymbol callbackFunc = NewtonWorldDestroyListenerCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetDestructorCallback(address, listener, callbackFunc);
	}
	
	public void listenerSetBodyDestroyCallback(Addressable listener, NewtonWorldListenerBodyDestroyCallback callback) {
		NativeSymbol callbackFunc = NewtonWorldListenerBodyDestroyCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetBodyDestroyCallback(address, listener, callbackFunc);
	}
	
	public void listenerSetBodyDestroyCallback(Addressable listener, NewtonWorldListenerBodyDestroyCallback callback, ResourceScope scope) {
		NativeSymbol callbackFunc = NewtonWorldListenerBodyDestroyCallback.allocate(callback, scope);
		Newton_h.NewtonWorldListenerSetBodyDestroyCallback(address, listener, callbackFunc);
	}
	
	public void listenerDebug(Addressable context) {
		Newton_h.NewtonWorldListenerDebug(address, context);
	}
	
	public MemoryAddress getListenerUserData(Addressable listener) {
		return Newton_h.NewtonWorldGetListenerUserData(address, listener);
	}
	
	public NewtonWorldListenerBodyDestroyCallback listenerGetBodyDestroyCallback(Addressable listener) {
		return NewtonWorldListenerBodyDestroyCallback.ofAddress(Newton_h.NewtonWorldListenerGetBodyDestroyCallback(address, listener), scope);
	}
	
	public NewtonWorldListenerBodyDestroyCallback listenerGetBodyDestroyCallback(Addressable listener, ResourceScope scope) {
		return NewtonWorldListenerBodyDestroyCallback.ofAddress(Newton_h.NewtonWorldListenerGetBodyDestroyCallback(address, listener), scope);
	}
	
	public void destroyAllBodies() {
		Newton_h.NewtonDestroyAllBodies(address);
	}
	/**
	 * This method wraps a memory address into a NewtonWorld object.
	 * This method is only meant to be used internally. Improper use of this method could
	 * result in errors or an exception.
	 * @param address - MemoryAddress of NewtonWorld
	 * @return NewtonWorld object
	 */
	protected static NewtonWorld wrap(MemoryAddress address) {
		return new NewtonWorld(address);
	}
	
	public record JointSerializationCallbacks(NewtonOnJointSerializationCallback serializeCallback, NewtonOnJointDeserializationCallback deserializeCallback) {}
}
