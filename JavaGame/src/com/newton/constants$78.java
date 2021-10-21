// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$78 {

    static final FunctionDescriptor NewtonHingeGetJointAngle$FUNC = FunctionDescriptor.of(C_FLOAT,
        C_POINTER
    );
    static final MethodHandle NewtonHingeGetJointAngle$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonHingeGetJointAngle",
        "(Ljdk/incubator/foreign/MemoryAddress;)F",
        constants$78.NewtonHingeGetJointAngle$FUNC, false
    );
    static final FunctionDescriptor NewtonHingeGetJointOmega$FUNC = FunctionDescriptor.of(C_FLOAT,
        C_POINTER
    );
    static final MethodHandle NewtonHingeGetJointOmega$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonHingeGetJointOmega",
        "(Ljdk/incubator/foreign/MemoryAddress;)F",
        constants$78.NewtonHingeGetJointOmega$FUNC, false
    );
    static final FunctionDescriptor NewtonHingeGetJointForce$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonHingeGetJointForce$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonHingeGetJointForce",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$78.NewtonHingeGetJointForce$FUNC, false
    );
    static final FunctionDescriptor NewtonHingeCalculateStopAlpha$FUNC = FunctionDescriptor.of(C_FLOAT,
        C_POINTER,
        C_POINTER,
        C_FLOAT
    );
    static final MethodHandle NewtonHingeCalculateStopAlpha$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonHingeCalculateStopAlpha",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;F)F",
        constants$78.NewtonHingeCalculateStopAlpha$FUNC, false
    );
    static final FunctionDescriptor NewtonConstraintCreateSlider$FUNC = FunctionDescriptor.of(C_POINTER,
        C_POINTER,
        C_POINTER,
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonConstraintCreateSlider$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonConstraintCreateSlider",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
        constants$78.NewtonConstraintCreateSlider$FUNC, false
    );
    static final FunctionDescriptor NewtonSliderSetUserCallback$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonSliderSetUserCallback$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonSliderSetUserCallback",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$78.NewtonSliderSetUserCallback$FUNC, false
    );
}


