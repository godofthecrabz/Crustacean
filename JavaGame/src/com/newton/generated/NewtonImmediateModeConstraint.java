// Generated by jextract

package com.newton.generated;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
public class NewtonImmediateModeConstraint {

    static final  GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
        MemoryLayout.sequenceLayout(8, MemoryLayout.sequenceLayout(6, Constants$root.C_FLOAT$LAYOUT)).withName("m_jacobian01"),
        MemoryLayout.sequenceLayout(8, MemoryLayout.sequenceLayout(6, Constants$root.C_FLOAT$LAYOUT)).withName("m_jacobian10"),
        MemoryLayout.sequenceLayout(8, Constants$root.C_FLOAT$LAYOUT).withName("m_minFriction"),
        MemoryLayout.sequenceLayout(8, Constants$root.C_FLOAT$LAYOUT).withName("m_maxFriction"),
        MemoryLayout.sequenceLayout(8, Constants$root.C_FLOAT$LAYOUT).withName("m_jointAccel"),
        MemoryLayout.sequenceLayout(8, Constants$root.C_FLOAT$LAYOUT).withName("m_jointStiffness")
    ).withName("NewtonImmediateModeConstraint");
    public static MemoryLayout $LAYOUT() {
        return NewtonImmediateModeConstraint.$struct$LAYOUT;
    }
    public static MemorySegment m_jacobian01$slice(MemorySegment seg) {
        return seg.asSlice(0, 192);
    }
    public static MemorySegment m_jacobian10$slice(MemorySegment seg) {
        return seg.asSlice(192, 192);
    }
    public static MemorySegment m_minFriction$slice(MemorySegment seg) {
        return seg.asSlice(384, 32);
    }
    public static MemorySegment m_maxFriction$slice(MemorySegment seg) {
        return seg.asSlice(416, 32);
    }
    public static MemorySegment m_jointAccel$slice(MemorySegment seg) {
        return seg.asSlice(448, 32);
    }
    public static MemorySegment m_jointStiffness$slice(MemorySegment seg) {
        return seg.asSlice(480, 32);
    }
    public static long sizeof() { return $LAYOUT().byteSize(); }
    public static MemorySegment allocate(SegmentAllocator allocator) { return allocator.allocate($LAYOUT()); }
    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }
    public static MemorySegment allocate(ResourceScope scope) { return allocate(SegmentAllocator.nativeAllocator(scope)); }
    public static MemorySegment allocateArray(int len, ResourceScope scope) {
        return allocateArray(len, SegmentAllocator.nativeAllocator(scope));
    }
    public static MemorySegment ofAddress(MemoryAddress addr, ResourceScope scope) { return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope); }
}


