// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface NewtonBallCallback {

    void apply(jdk.incubator.foreign.MemoryAddress x0, float x1);
    static MemoryAddress allocate(NewtonBallCallback fi) {
        return RuntimeHelper.upcallStub(NewtonBallCallback.class, fi, constants$15.NewtonBallCallback$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;F)V");
    }
    static MemoryAddress allocate(NewtonBallCallback fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(NewtonBallCallback.class, fi, constants$15.NewtonBallCallback$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;F)V", scope);
    }
    static NewtonBallCallback ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0, float x1) -> {
            try {
                constants$15.NewtonBallCallback$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


