// Generated by jextract

package com.newton;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.CLinker.*;
class constants$41 {

    static final FunctionDescriptor NewtonCollisionSetMode$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_INT
    );
    static final MethodHandle NewtonCollisionSetMode$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonCollisionSetMode",
        "(Ljdk/incubator/foreign/MemoryAddress;I)V",
        constants$41.NewtonCollisionSetMode$FUNC, false
    );
    static final FunctionDescriptor NewtonConvexHullGetFaceIndices$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER,
        C_INT,
        C_POINTER
    );
    static final MethodHandle NewtonConvexHullGetFaceIndices$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonConvexHullGetFaceIndices",
        "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)I",
        constants$41.NewtonConvexHullGetFaceIndices$FUNC, false
    );
    static final FunctionDescriptor NewtonConvexHullGetVertexData$FUNC = FunctionDescriptor.of(C_INT,
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonConvexHullGetVertexData$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonConvexHullGetVertexData",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        constants$41.NewtonConvexHullGetVertexData$FUNC, false
    );
    static final FunctionDescriptor NewtonConvexCollisionCalculateVolume$FUNC = FunctionDescriptor.of(C_FLOAT,
        C_POINTER
    );
    static final MethodHandle NewtonConvexCollisionCalculateVolume$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonConvexCollisionCalculateVolume",
        "(Ljdk/incubator/foreign/MemoryAddress;)F",
        constants$41.NewtonConvexCollisionCalculateVolume$FUNC, false
    );
    static final FunctionDescriptor NewtonConvexCollisionCalculateInertialMatrix$FUNC = FunctionDescriptor.ofVoid(
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonConvexCollisionCalculateInertialMatrix$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonConvexCollisionCalculateInertialMatrix",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
        constants$41.NewtonConvexCollisionCalculateInertialMatrix$FUNC, false
    );
    static final FunctionDescriptor NewtonConvexCollisionCalculateBuoyancyVolume$FUNC = FunctionDescriptor.of(C_FLOAT,
        C_POINTER,
        C_POINTER,
        C_POINTER,
        C_POINTER
    );
    static final MethodHandle NewtonConvexCollisionCalculateBuoyancyVolume$MH = RuntimeHelper.downcallHandle(
        Newton_h.LIBRARIES, "NewtonConvexCollisionCalculateBuoyancyVolume",
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)F",
        constants$41.NewtonConvexCollisionCalculateBuoyancyVolume$FUNC, false
    );
}


