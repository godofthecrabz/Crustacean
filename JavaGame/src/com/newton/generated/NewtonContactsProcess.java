// Generated by jextract

package com.newton.generated;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface NewtonContactsProcess {

    void apply(jdk.incubator.foreign.MemoryAddress x0, float x1, int x2);
    static MemoryAddress allocate(NewtonContactsProcess fi) {
        return RuntimeHelper.upcallStub(NewtonContactsProcess.class, fi, constants$13.NewtonContactsProcess$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;FI)V");
    }
    static MemoryAddress allocate(NewtonContactsProcess fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(NewtonContactsProcess.class, fi, constants$13.NewtonContactsProcess$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;FI)V", scope);
    }
    static NewtonContactsProcess ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0, float x1, int x2) -> {
            try {
                constants$13.NewtonContactsProcess$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}

