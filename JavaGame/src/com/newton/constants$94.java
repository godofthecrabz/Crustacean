// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$94 {

    static final FunctionDescriptor NewtonMeshAddVertexColor$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_FLOAT,
        C_FLOAT,
        C_FLOAT,
        C_FLOAT
    );
    static final MethodHandle NewtonMeshAddVertexColor$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshAddVertexColor",
        "(Ljdk/incubator/foreign/MemoryAddress;FFFF)V",
        constants$94.NewtonMeshAddVertexColor$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshEndFace$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER
    );
    static final MethodHandle NewtonMeshEndFace$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshEndFace",
        "(Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$94.NewtonMeshEndFace$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshEndBuild$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER
    );
    static final MethodHandle NewtonMeshEndBuild$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshEndBuild",
        "(Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$94.NewtonMeshEndBuild$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshClearVertexFormat$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER
    );
    static final MethodHandle NewtonMeshClearVertexFormat$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshClearVertexFormat",
        "(Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$94.NewtonMeshClearVertexFormat$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshBuildFromVertexListIndexList$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonMeshBuildFromVertexListIndexList$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshBuildFromVertexListIndexList",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$94.NewtonMeshBuildFromVertexListIndexList$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshGetPointCount$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonMeshGetPointCount$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonMeshGetPointCount",
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$94.NewtonMeshGetPointCount$FUNC, false
    );
}


