// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public class NewtonCompoundCollisionParam {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
        C_INT.withName("m_chidrenCount")
    ).withName("NewtonCompoundCollisionParam");
    public static MemoryLayout $LAYOUT() {
        return NewtonCompoundCollisionParam.$struct$LAYOUT;
    }
    static final VarHandle m_chidrenCount$VH = $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("m_chidrenCount"));
    public static VarHandle m_chidrenCount$VH() {
        return NewtonCompoundCollisionParam.m_chidrenCount$VH;
    }
    public static int m_chidrenCount$get(MemorySegment seg) {
        return (int)NewtonCompoundCollisionParam.m_chidrenCount$VH.get(seg);
    }
    public static void m_chidrenCount$set( MemorySegment seg, int x) {
        NewtonCompoundCollisionParam.m_chidrenCount$VH.set(seg, x);
    }
    public static int m_chidrenCount$get(MemorySegment seg, long index) {
        return (int)NewtonCompoundCollisionParam.m_chidrenCount$VH.get(seg.asSlice(index*sizeof()));
    }
    public static void m_chidrenCount$set(MemorySegment seg, long index, int x) {
        NewtonCompoundCollisionParam.m_chidrenCount$VH.set(seg.asSlice(index*sizeof()), x);
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

