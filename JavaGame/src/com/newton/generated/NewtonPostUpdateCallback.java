// Generated by jextract

package com.newton.generated;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface NewtonPostUpdateCallback {

    void apply(jdk.incubator.foreign.MemoryAddress x0, float x1);
    static MemoryAddress allocate(NewtonPostUpdateCallback fi) {
        return RuntimeHelper.upcallStub(NewtonPostUpdateCallback.class, fi, constants$1.NewtonPostUpdateCallback$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;F)V");
    }
    static MemoryAddress allocate(NewtonPostUpdateCallback fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(NewtonPostUpdateCallback.class, fi, constants$1.NewtonPostUpdateCallback$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;F)V", scope);
    }
    static NewtonPostUpdateCallback ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0, float x1) -> {
            try {
                constants$1.NewtonPostUpdateCallback$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}

