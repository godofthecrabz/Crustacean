// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$63 {

    static final FunctionDescriptor NewtonBodySetAngularDamping$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodySetAngularDamping$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodySetAngularDamping",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$63.NewtonBodySetAngularDamping$FUNC, false
    );
    static final FunctionDescriptor NewtonBodySetCollision$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodySetCollision$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodySetCollision",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$63.NewtonBodySetCollision$FUNC, false
    );
    static final FunctionDescriptor NewtonBodySetCollisionScale$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_FLOAT,
        C_FLOAT,
        C_FLOAT
    );
    static final MethodHandle NewtonBodySetCollisionScale$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodySetCollisionScale",
        "(Ljdk/incubator/foreign/MemoryAddress;FFF)V",
        constants$63.NewtonBodySetCollisionScale$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetSleepState$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetSleepState$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetSleepState",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$63.NewtonBodyGetSleepState$FUNC, false
    );
    static final FunctionDescriptor NewtonBodySetSleepState$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_INT
    );
    static final MethodHandle NewtonBodySetSleepState$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodySetSleepState",
        "(Ljdk/incubator/foreign/MemoryAddress;I)V",
        constants$63.NewtonBodySetSleepState$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetAutoSleep$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetAutoSleep$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetAutoSleep",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$63.NewtonBodyGetAutoSleep$FUNC, false
    );
}


