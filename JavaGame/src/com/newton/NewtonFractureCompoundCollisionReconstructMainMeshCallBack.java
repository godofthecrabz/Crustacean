// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface NewtonFractureCompoundCollisionReconstructMainMeshCallBack {

    void apply(jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2);
    static MemoryAddress allocate(NewtonFractureCompoundCollisionReconstructMainMeshCallBack fi) {
        return RuntimeHelper.upcallStub(NewtonFractureCompoundCollisionReconstructMainMeshCallBack.class, fi, constants$12.NewtonFractureCompoundCollisionReconstructMainMeshCallBack$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(NewtonFractureCompoundCollisionReconstructMainMeshCallBack fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(NewtonFractureCompoundCollisionReconstructMainMeshCallBack.class, fi, constants$12.NewtonFractureCompoundCollisionReconstructMainMeshCallBack$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static NewtonFractureCompoundCollisionReconstructMainMeshCallBack ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$12.NewtonFractureCompoundCollisionReconstructMainMeshCallBack$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


