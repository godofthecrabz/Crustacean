// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$64 {

    static final FunctionDescriptor NewtonBodySetAutoSleep$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_INT
    );
    static final MethodHandle NewtonBodySetAutoSleep$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodySetAutoSleep",
        "(Ljdk/incubator/foreign/MemoryAddress;I)V",
        constants$64.NewtonBodySetAutoSleep$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetFreezeState$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetFreezeState$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetFreezeState",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$64.NewtonBodyGetFreezeState$FUNC, false
    );
    static final FunctionDescriptor NewtonBodySetFreezeState$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_INT
    );
    static final MethodHandle NewtonBodySetFreezeState$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodySetFreezeState",
        "(Ljdk/incubator/foreign/MemoryAddress;I)V",
        constants$64.NewtonBodySetFreezeState$FUNC, false
    );
    static final FunctionDescriptor NewtonBodyGetGyroscopicTorque$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonBodyGetGyroscopicTorque$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodyGetGyroscopicTorque",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$64.NewtonBodyGetGyroscopicTorque$FUNC, false
    );
    static final FunctionDescriptor NewtonBodySetGyroscopicTorque$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_INT
    );
    static final MethodHandle NewtonBodySetGyroscopicTorque$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodySetGyroscopicTorque",
        "(Ljdk/incubator/foreign/MemoryAddress;I)V",
        constants$64.NewtonBodySetGyroscopicTorque$FUNC, false
    );
    static final FunctionDescriptor NewtonBodySetDestructorCallback$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonBodySetDestructorCallback$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonBodySetDestructorCallback",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$64.NewtonBodySetDestructorCallback$FUNC, false
    );
}


