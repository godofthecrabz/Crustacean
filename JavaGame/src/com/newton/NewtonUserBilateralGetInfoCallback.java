// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface NewtonUserBilateralGetInfoCallback {

    void apply(jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);
    static MemoryAddress allocate(NewtonUserBilateralGetInfoCallback fi) {
        return RuntimeHelper.upcallStub(NewtonUserBilateralGetInfoCallback.class, fi, constants$17.NewtonUserBilateralGetInfoCallback$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(NewtonUserBilateralGetInfoCallback fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(NewtonUserBilateralGetInfoCallback.class, fi, constants$17.NewtonUserBilateralGetInfoCallback$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static NewtonUserBilateralGetInfoCallback ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
            try {
                constants$17.NewtonUserBilateralGetInfoCallback$MH.invokeExact((Addressable)addr, x0, x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


