// Generated by jextract

package com.newton.generated;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$0 {

    static final FunctionDescriptor NewtonAllocMemory$FUNC = FunctionDescriptor.of(C_POINTER,
        C_INT
    );
    static final MethodHandle NewtonAllocMemory$MH = RuntimeHelper.downcallHandle(
        "(I)Ljdk/incubator/foreign/MemoryAddress;",
        constants$0.NewtonAllocMemory$FUNC, false
    );
    static final FunctionDescriptor NewtonFreeMemory$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_INT
    );
    static final MethodHandle NewtonFreeMemory$MH = RuntimeHelper.downcallHandle(
        "(Ljdk/incubator/foreign/MemoryAddress;I)V",
        constants$0.NewtonFreeMemory$FUNC, false
    );
    static final FunctionDescriptor NewtonWorldDestructorCallback$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER
    );
    static final MethodHandle NewtonWorldDestructorCallback$MH = RuntimeHelper.downcallHandle(
        "(Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$0.NewtonWorldDestructorCallback$FUNC, false
    );
}

