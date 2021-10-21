// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface NewtonCollisionIterator {

    void apply(jdk.incubator.foreign.MemoryAddress x0, int x1, jdk.incubator.foreign.MemoryAddress x2, int x3);
    static MemoryAddress allocate(NewtonCollisionIterator fi) {
        return RuntimeHelper.upcallStub(NewtonCollisionIterator.class, fi, constants$15.NewtonCollisionIterator$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;I)V");
    }
    static MemoryAddress allocate(NewtonCollisionIterator fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(NewtonCollisionIterator.class, fi, constants$15.NewtonCollisionIterator$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;I)V", scope);
    }
    static NewtonCollisionIterator ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0, int x1, jdk.incubator.foreign.MemoryAddress x2, int x3) -> {
            try {
                constants$15.NewtonCollisionIterator$MH.invokeExact((Addressable)addr, x0, x1, x2, x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


