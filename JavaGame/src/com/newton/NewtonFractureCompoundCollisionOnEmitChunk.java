// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
public interface NewtonFractureCompoundCollisionOnEmitChunk {

    void apply(jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2);
    static MemoryAddress allocate(NewtonFractureCompoundCollisionOnEmitChunk fi) {
        return RuntimeHelper.upcallStub(NewtonFractureCompoundCollisionOnEmitChunk.class, fi, constants$11.NewtonFractureCompoundCollisionOnEmitChunk$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V");
    }
    static MemoryAddress allocate(NewtonFractureCompoundCollisionOnEmitChunk fi, ResourceScope scope) {
        return RuntimeHelper.upcallStub(NewtonFractureCompoundCollisionOnEmitChunk.class, fi, constants$11.NewtonFractureCompoundCollisionOnEmitChunk$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V", scope);
    }
    static NewtonFractureCompoundCollisionOnEmitChunk ofAddress(MemoryAddress addr) {
        return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2) -> {
            try {
                constants$11.NewtonFractureCompoundCollisionOnEmitChunk$MH.invokeExact((Addressable)addr, x0, x1, x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        };
    }
}


