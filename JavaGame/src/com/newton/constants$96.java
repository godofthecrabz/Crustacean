// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$96 {

    static final FunctionDescriptor NewtonMeshGetUV1Channel$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonMeshGetUV1Channel$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshGetUV1Channel",
        "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$96.NewtonMeshGetUV1Channel$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshGetVertexColorChannel$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonMeshGetVertexColorChannel$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshGetVertexColorChannel",
        "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)V",
        constants$96.NewtonMeshGetVertexColorChannel$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshHasNormalChannel$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonMeshHasNormalChannel$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshHasNormalChannel",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$96.NewtonMeshHasNormalChannel$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshHasBinormalChannel$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonMeshHasBinormalChannel$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshHasBinormalChannel",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$96.NewtonMeshHasBinormalChannel$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshHasUV0Channel$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonMeshHasUV0Channel$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshHasUV0Channel",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$96.NewtonMeshHasUV0Channel$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshHasUV1Channel$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonMeshHasUV1Channel$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshHasUV1Channel",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$96.NewtonMeshHasUV1Channel$FUNC, false
    );
}


