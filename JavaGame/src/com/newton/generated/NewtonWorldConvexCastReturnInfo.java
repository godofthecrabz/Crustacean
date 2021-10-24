// Generated by jextract

package com.newton.generated;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public class NewtonWorldConvexCastReturnInfo {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
        MemoryLayout.sequenceLayout(4, C_FLOAT).withName("m_point"),
        MemoryLayout.sequenceLayout(4, C_FLOAT).withName("m_normal"),
        C_LONG_LONG.withName("m_contactID"),
        C_POINTER.withName("m_hitBody"),
        C_FLOAT.withName("m_penetration"),
        MemoryLayout.paddingLayout(32)
    ).withName("NewtonWorldConvexCastReturnInfo");
    public static MemoryLayout $LAYOUT() {
        return NewtonWorldConvexCastReturnInfo.$struct$LAYOUT;
    }
    public static MemorySegment m_point$slice(MemorySegment seg) {
        return seg.asSlice(0, 16);
    }
    public static MemorySegment m_normal$slice(MemorySegment seg) {
        return seg.asSlice(16, 16);
    }
    static final VarHandle m_contactID$VH = $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("m_contactID"));
    public static VarHandle m_contactID$VH() {
        return NewtonWorldConvexCastReturnInfo.m_contactID$VH;
    }
    public static long m_contactID$get(MemorySegment seg) {
        return (long)NewtonWorldConvexCastReturnInfo.m_contactID$VH.get(seg);
    }
    public static void m_contactID$set( MemorySegment seg, long x) {
        NewtonWorldConvexCastReturnInfo.m_contactID$VH.set(seg, x);
    }
    public static long m_contactID$get(MemorySegment seg, long index) {
        return (long)NewtonWorldConvexCastReturnInfo.m_contactID$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void m_contactID$set(MemorySegment seg, long index, long x) {
        NewtonWorldConvexCastReturnInfo.m_contactID$VH.set(seg.asSlice(index*sizeof()), x);
    }
    static final VarHandle m_hitBody$VH = MemoryHandles.asAddressVarHandle($struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("m_hitBody")));
    public static VarHandle m_hitBody$VH() {
        return NewtonWorldConvexCastReturnInfo.m_hitBody$VH;
    }
    public static MemoryAddress m_hitBody$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress)NewtonWorldConvexCastReturnInfo.m_hitBody$VH.get(seg);
    }
    public static void m_hitBody$set( MemorySegment seg, MemoryAddress x) {
        NewtonWorldConvexCastReturnInfo.m_hitBody$VH.set(seg, x);
    }
    public static MemoryAddress m_hitBody$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)NewtonWorldConvexCastReturnInfo.m_hitBody$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void m_hitBody$set(MemorySegment seg, long index, MemoryAddress x) {
        NewtonWorldConvexCastReturnInfo.m_hitBody$VH.set(seg.asSlice(index*sizeof()), x);
    }
    static final VarHandle m_penetration$VH = $struct$LAYOUT.varHandle(float.class, MemoryLayout.PathElement.groupElement("m_penetration"));
    public static VarHandle m_penetration$VH() {
        return NewtonWorldConvexCastReturnInfo.m_penetration$VH;
    }
    public static float m_penetration$get(MemorySegment seg) {
        return (float)NewtonWorldConvexCastReturnInfo.m_penetration$VH.get(seg);
    }
    public static void m_penetration$set( MemorySegment seg, float x) {
        NewtonWorldConvexCastReturnInfo.m_penetration$VH.set(seg, x);
    }
    public static float m_penetration$get(MemorySegment seg, long index) {
        return (float)NewtonWorldConvexCastReturnInfo.m_penetration$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void m_penetration$set(MemorySegment seg, long index, float x) {
        NewtonWorldConvexCastReturnInfo.m_penetration$VH.set(seg.asSlice(index*sizeof()), x);
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

