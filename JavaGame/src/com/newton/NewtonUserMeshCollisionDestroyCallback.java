// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface NewtonUserMeshCollisionDestroyCallback {

    void apply(jdk.incubator.foreign.MemoryAddress x0);
    static MemoryAddress allocate(NewtonUserMeshCollisionDestroyCallback fi) {
        return RuntimeHelper.upcallStub(NewtonUserMeshCollisionDestroyCallback.class, fi, constants$6.NewtonUserMeshCollisionDestroyCallback$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(NewtonUserMeshCollisionDestroyCallback fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(NewtonUserMeshCollisionDestroyCallback.class, fi, constants$6.NewtonUserMeshCollisionDestroyCallback$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static NewtonUserMeshCollisionDestroyCallback ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0) -> {
            try {
                constants$6.NewtonUserMeshCollisionDestroyCallback$MH.invokeExact((Addressable)addr, x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}

