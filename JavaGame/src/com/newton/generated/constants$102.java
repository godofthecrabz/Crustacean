// Generated by jextract

package com.newton.generated;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
class constants$102 {

    static final FunctionDescriptor NewtonMeshGetEdgeIndices$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonMeshGetEdgeIndices$MH = RuntimeHelper.downcallHandle(
        "NewtonMeshGetEdgeIndices",
        constants$102.NewtonMeshGetEdgeIndices$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshGetFirstFace$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonMeshGetFirstFace$MH = RuntimeHelper.downcallHandle(
        "NewtonMeshGetFirstFace",
        constants$102.NewtonMeshGetFirstFace$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshGetNextFace$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonMeshGetNextFace$MH = RuntimeHelper.downcallHandle(
        "NewtonMeshGetNextFace",
        constants$102.NewtonMeshGetNextFace$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshIsFaceOpen$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonMeshIsFaceOpen$MH = RuntimeHelper.downcallHandle(
        "NewtonMeshIsFaceOpen",
        constants$102.NewtonMeshIsFaceOpen$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshGetFaceMaterial$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonMeshGetFaceMaterial$MH = RuntimeHelper.downcallHandle(
        "NewtonMeshGetFaceMaterial",
        constants$102.NewtonMeshGetFaceMaterial$FUNC, false
    );
    static final FunctionDescriptor NewtonMeshGetFaceIndexCount$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonMeshGetFaceIndexCount$MH = RuntimeHelper.downcallHandle(
        "NewtonMeshGetFaceIndexCount",
        constants$102.NewtonMeshGetFaceIndexCount$FUNC, false
    );
}


