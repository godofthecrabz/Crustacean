// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$20 {

    static final FunctionDescriptor NewtonSetPostUpdateCallback$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonSetPostUpdateCallback$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonSetPostUpdateCallback",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$20.NewtonSetPostUpdateCallback$FUNC, false
    );
    static final FunctionDescriptor NewtonAlloc$FUNC = FunctionDescriptor.of(C_POINTER,
        C_INT
    );
    static final MethodHandle NewtonAlloc$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonAlloc",
        "(I)Ljdk/incubator/foreign/MemoryAddress;",
        constants$20.NewtonAlloc$FUNC, false
    );
    static final FunctionDescriptor NewtonFree$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER
    );
    static final MethodHandle NewtonFree$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonFree",
        "(Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$20.NewtonFree$FUNC, false
    );
    static final FunctionDescriptor NewtonLoadPlugins$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonLoadPlugins$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonLoadPlugins",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$20.NewtonLoadPlugins$FUNC, false
    );
    static final FunctionDescriptor NewtonUnloadPlugins$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER
    );
    static final MethodHandle NewtonUnloadPlugins$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonUnloadPlugins",
        "(Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$20.NewtonUnloadPlugins$FUNC, false
    );
    static final FunctionDescriptor NewtonCurrentPlugin$FUNC = FunctionDescriptor.of(C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonCurrentPlugin$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonCurrentPlugin",
        "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
        constants$20.NewtonCurrentPlugin$FUNC, false
    );
}


