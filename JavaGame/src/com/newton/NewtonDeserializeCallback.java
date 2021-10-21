// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface NewtonDeserializeCallback {

    void apply(jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, int x2);
    static MemoryAddress allocate(NewtonDeserializeCallback fi) {
        return RuntimeHelper.upcallStub(NewtonDeserializeCallback.class, fi, constants$4.NewtonDeserializeCallback$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)V");
    }
    static MemoryAddress allocate(NewtonDeserializeCallback fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(NewtonDeserializeCallback.class, fi, constants$4.NewtonDeserializeCallback$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)V", scope);
    }
    static NewtonDeserializeCallback ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, int x2) -> {
            try {
                constants$4.NewtonDeserializeCallback$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}

