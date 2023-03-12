package main.engine.enginelayouts;

import org.joml.Vector3f;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

public final class Vector3fLayout {
    public static final SequenceLayout LAYOUT = MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_FLOAT);
    public static final VarHandle X_HANDLE = LAYOUT.varHandle(MemoryLayout.PathElement.sequenceElement(0));
    public static final VarHandle Y_HANDLE = LAYOUT.varHandle(MemoryLayout.PathElement.sequenceElement(1));
    public static final VarHandle Z_HANDLE = LAYOUT.varHandle(MemoryLayout.PathElement.sequenceElement(2));

    private Vector3fLayout() {}

    public static float getX(MemorySegment segment, long offset) {
        return (float) X_HANDLE.get(segment.asSlice(offset));
    }

    public static float getX(MemorySegment segment) {
        return getX(segment, 0);
    }

    public static float getY(MemorySegment segment, long offset) {
        return (float) Y_HANDLE.get(segment.asSlice(offset));
    }

    public static float getY(MemorySegment segment) {
        return getY(segment, 0);
    }

    public static float getZ(MemorySegment segment, long offset) {
        return (float) Z_HANDLE.get(segment.asSlice(offset));
    }

    public static float getZ(MemorySegment segment) {
        return getZ(segment, 0);
    }

    public static void setX(MemorySegment segment, long offset, float x) {
        X_HANDLE.set(segment.asSlice(offset), x);
    }

    public static void setX(MemorySegment segment, float x) {
        setX(segment, 0, x);
    }

    public static void setY(MemorySegment segment, long offset, float y) {
        Y_HANDLE.set(segment.asSlice(offset), y);
    }

    public static void setY(MemorySegment segment, float y) {
        setY(segment, 0, y);
    }

    public static void setZ(MemorySegment segment, long offset, float z) {
        Z_HANDLE.set(segment.asSlice(offset), z);
    }

    public static void setZ(MemorySegment segment, float z) {
        setZ(segment, 0, z);
    }

    public static Vector3f getVector3f(MemorySegment segment, long offset) {
        MemorySegment vecSegment = segment.asSlice(offset);
        Vector3f vector = new Vector3f(
                (float) X_HANDLE.get(vecSegment),
                (float) Y_HANDLE.get(vecSegment),
                (float) Z_HANDLE.get(vecSegment)
        );
        return vector;
    }

    public static Vector3f getVector3f(MemorySegment segment) {
        return getVector3f(segment, 0);
    }

    public static void setVector3f(MemorySegment segment, long offset, Vector3f value) {
        MemorySegment vecSegment = segment.asSlice(offset);
        X_HANDLE.set(vecSegment, value.x);
        Y_HANDLE.set(vecSegment, value.y);
        Z_HANDLE.set(vecSegment, value.z);
    }

    public static void setVector3f(MemorySegment segment, Vector3f value) {
        setVector3f(segment, 0, value);
    }
}
