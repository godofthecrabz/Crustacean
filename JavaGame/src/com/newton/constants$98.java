// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$98 {

    static final FunctionDescriptor NewtonMeshMaterialGetIndexCount$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER,
        C_POINTER,
        C_INT
    );
    static final MethodHandle NewtonMeshMaterialGetIndexCount$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshMaterialGetIndexCount",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        constants$98.NewtonMeshMaterialGetIndexCount$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshMaterialGetIndexStream$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER,
        C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonMeshMaterialGetIndexStream$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshMaterialGetIndexStream",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$98.NewtonMeshMaterialGetIndexStream$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshMaterialGetIndexStreamShort$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER,
        C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonMeshMaterialGetIndexStreamShort$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshMaterialGetIndexStreamShort",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$98.NewtonMeshMaterialGetIndexStreamShort$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshCreateFirstSingleSegment$FUNC = FunctionDescriptor.of(C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonMeshCreateFirstSingleSegment$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshCreateFirstSingleSegment",
        "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
        constants$98.NewtonMeshCreateFirstSingleSegment$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshCreateNextSingleSegment$FUNC = FunctionDescriptor.of(C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonMeshCreateNextSingleSegment$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshCreateNextSingleSegment",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
        constants$98.NewtonMeshCreateNextSingleSegment$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshCreateFirstLayer$FUNC = FunctionDescriptor.of(C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonMeshCreateFirstLayer$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshCreateFirstLayer",
        "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
        constants$98.NewtonMeshCreateFirstLayer$FUNC, false
    );
}


