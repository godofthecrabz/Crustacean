// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$29 {

    static final FunctionDescriptor NewtonWorldListenerSetPostUpdateCallback$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonWorldListenerSetPostUpdateCallback$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonWorldListenerSetPostUpdateCallback",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$29.NewtonWorldListenerSetPostUpdateCallback$FUNC, false
    );
    static final FunctionDescriptor NewtonWorldListenerSetDestructorCallback$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonWorldListenerSetDestructorCallback$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonWorldListenerSetDestructorCallback",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$29.NewtonWorldListenerSetDestructorCallback$FUNC, false
    );
    static final FunctionDescriptor NewtonWorldListenerSetBodyDestroyCallback$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonWorldListenerSetBodyDestroyCallback$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonWorldListenerSetBodyDestroyCallback",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$29.NewtonWorldListenerSetBodyDestroyCallback$FUNC, false
    );
    static final FunctionDescriptor NewtonWorldListenerDebug$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonWorldListenerDebug$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonWorldListenerDebug",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$29.NewtonWorldListenerDebug$FUNC, false
    );
    static final FunctionDescriptor NewtonWorldGetListenerUserData$FUNC = FunctionDescriptor.of(C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonWorldGetListenerUserData$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonWorldGetListenerUserData",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
        constants$29.NewtonWorldGetListenerUserData$FUNC, false
    );
    static final FunctionDescriptor NewtonWorldListenerGetBodyDestroyCallback$FUNC = FunctionDescriptor.of(C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonWorldListenerGetBodyDestroyCallback$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonWorldListenerGetBodyDestroyCallback",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
        constants$29.NewtonWorldListenerGetBodyDestroyCallback$FUNC, false
    );
}

