// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$67 {

    static final FunctionDescriptor NewtonBodyGetContinuousCollisionMode$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetContinuousCollisionMode$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetContinuousCollisionMode",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$67.NewtonBodyGetContinuousCollisionMode$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetJointRecursiveCollision$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetJointRecursiveCollision$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetJointRecursiveCollision",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$67.NewtonBodyGetJointRecursiveCollision$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetPosition$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetPosition$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetPosition",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$67.NewtonBodyGetPosition$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetMatrix$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetMatrix$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetMatrix",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$67.NewtonBodyGetMatrix$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetRotation$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetRotation$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetRotation",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$67.NewtonBodyGetRotation$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetMass$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER,
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetMass$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetMass",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$67.NewtonBodyGetMass$FUNC, false
    );
}


