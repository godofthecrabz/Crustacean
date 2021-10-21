// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$69 {

    static final FunctionDescriptor NewtonBodyGetAcceleration$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetAcceleration$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetAcceleration",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$69.NewtonBodyGetAcceleration$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetForce$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetForce$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetForce",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$69.NewtonBodyGetForce$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetTorque$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetTorque$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetTorque",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$69.NewtonBodyGetTorque$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetCentreOfMass$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetCentreOfMass$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetCentreOfMass",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$69.NewtonBodyGetCentreOfMass$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetPointVelocity$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetPointVelocity$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetPointVelocity",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$69.NewtonBodyGetPointVelocity$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyApplyImpulsePair$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER,
        C_POINTER,
        C_FLOAT
    );
    static final MethodHandle NewtonBodyApplyImpulsePair$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyApplyImpulsePair",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;F)V",
        constants$69.NewtonBodyApplyImpulsePair$FUNC, false
    );
}

