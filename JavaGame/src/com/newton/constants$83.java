// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$83 {

    static final FunctionDescriptor NewtonUpVectorSetPin$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonUpVectorSetPin$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonUpVectorSetPin",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$83.NewtonUpVectorSetPin$FUNC, false
    );
    static final FunctionDescriptor NewtonConstraintCreateUserJoint$FUNC = FunctionDescriptor.of(C_POINTER,
        C_POINTER,
        C_INT,
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonConstraintCreateUserJoint$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonConstraintCreateUserJoint",
        "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
        constants$83.NewtonConstraintCreateUserJoint$FUNC, false
    );
    static final FunctionDescriptor NewtonUserJointGetSolverModel$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonUserJointGetSolverModel$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonUserJointGetSolverModel",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$83.NewtonUserJointGetSolverModel$FUNC, false
    );
    static final FunctionDescriptor NewtonUserJointSetSolverModel$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_INT
    );
    static final MethodHandle NewtonUserJointSetSolverModel$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonUserJointSetSolverModel",
        "(Ljdk/incubator/foreign/MemoryAddress;I)V",
        constants$83.NewtonUserJointSetSolverModel$FUNC, false
    );
    static final FunctionDescriptor NewtonUserJointMassScale$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_FLOAT,
        C_FLOAT
    );
    static final MethodHandle NewtonUserJointMassScale$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonUserJointMassScale",
        "(Ljdk/incubator/foreign/MemoryAddress;FF)V",
        constants$83.NewtonUserJointMassScale$FUNC, false
    );
    static final FunctionDescriptor NewtonUserJointSetFeedbackCollectorCallback$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonUserJointSetFeedbackCollectorCallback$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonUserJointSetFeedbackCollectorCallback",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$83.NewtonUserJointSetFeedbackCollectorCallback$FUNC, false
    );
}


