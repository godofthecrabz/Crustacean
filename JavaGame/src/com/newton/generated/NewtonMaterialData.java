// Generated by jextract

package com.newton.generated;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public class NewtonMaterialData {

    static final MemoryLayout $union$LAYOUT = MemoryLayout.unionLayout(
        C_POINTER.withName("m_ptr"),
        C_LONG_LONG.withName("m_int"),
        C_FLOAT.withName("m_float")
    );
    public static MemoryLayout $LAYOUT() {
        return NewtonMaterialData.$union$LAYOUT;
    }
    static final VarHandle m_ptr$VH = MemoryHandles.asAddressVarHandle($union$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("m_ptr")));
    public static VarHandle m_ptr$VH() {
        return NewtonMaterialData.m_ptr$VH;
    }
    public static MemoryAddress m_ptr$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress)NewtonMaterialData.m_ptr$VH.get(seg);
    }
    public static void m_ptr$set( MemorySegment seg, MemoryAddress x) {
        NewtonMaterialData.m_ptr$VH.set(seg, x);
    }
    public static MemoryAddress m_ptr$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)NewtonMaterialData.m_ptr$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void m_ptr$set(MemorySegment seg, long index, MemoryAddress x) {
        NewtonMaterialData.m_ptr$VH.set(seg.asSlice(index*sizeof()), x);
    }
    static final VarHandle m_int$VH = $union$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("m_int"));
    public static VarHandle m_int$VH() {
        return NewtonMaterialData.m_int$VH;
    }
    public static long m_int$get(MemorySegment seg) {
        return (long)NewtonMaterialData.m_int$VH.get(seg);
    }
    public static void m_int$set( MemorySegment seg, long x) {
        NewtonMaterialData.m_int$VH.set(seg, x);
    }
    public static long m_int$get(MemorySegment seg, long index) {
        return (long)NewtonMaterialData.m_int$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void m_int$set(MemorySegment seg, long index, long x) {
        NewtonMaterialData.m_int$VH.set(seg.asSlice(index*sizeof()), x);
    }
    static final VarHandle m_float$VH = $union$LAYOUT.varHandle(float.class, MemoryLayout.PathElement.groupElement("m_float"));
    public static VarHandle m_float$VH() {
        return NewtonMaterialData.m_float$VH;
    }
    public static float m_float$get(MemorySegment seg) {
        return (float)NewtonMaterialData.m_float$VH.get(seg);
    }
    public static void m_float$set( MemorySegment seg, float x) {
        NewtonMaterialData.m_float$VH.set(seg, x);
    }
    public static float m_float$get(MemorySegment seg, long index) {
        return (float)NewtonMaterialData.m_float$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void m_float$set(MemorySegment seg, long index, float x) {
        NewtonMaterialData.m_float$VH.set(seg.asSlice(index*sizeof()), x);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocate(ResourceScope scope) { return allocate(SegmentAllocator.ofScope(scope)); }
    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment allocateArray(int len, ResourceScope scope) {
        return allocateArray(len, SegmentAllocator.ofScope(scope));
    }
    public static MemorySegment ofAddress(MemoryAddress addr, ResourceScope scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}

