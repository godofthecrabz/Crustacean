// Generated by jextract

package com.newton.generated;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import jdk.incubator.foreign.*;
import static jdk.incubator.foreign.ValueLayout.*;
class constants$24 {

    static final FunctionDescriptor NewtonGetNumberOfSubsteps$FUNC = FunctionDescriptor.of(Constants$root.C_LONG$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonGetNumberOfSubsteps$MH = RuntimeHelper.downcallHandle(
        "NewtonGetNumberOfSubsteps",
        constants$24.NewtonGetNumberOfSubsteps$FUNC, false
    );
    static final FunctionDescriptor NewtonSetNumberOfSubsteps$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_LONG$LAYOUT
    );
    static final MethodHandle NewtonSetNumberOfSubsteps$MH = RuntimeHelper.downcallHandle(
        "NewtonSetNumberOfSubsteps",
        constants$24.NewtonSetNumberOfSubsteps$FUNC, false
    );
    static final FunctionDescriptor NewtonGetLastUpdateTime$FUNC = FunctionDescriptor.of(Constants$root.C_FLOAT$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonGetLastUpdateTime$MH = RuntimeHelper.downcallHandle(
        "NewtonGetLastUpdateTime",
        constants$24.NewtonGetLastUpdateTime$FUNC, false
    );
    static final FunctionDescriptor NewtonSerializeToFile$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonSerializeToFile$MH = RuntimeHelper.downcallHandle(
        "NewtonSerializeToFile",
        constants$24.NewtonSerializeToFile$FUNC, false
    );
    static final FunctionDescriptor NewtonDeserializeFromFile$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonDeserializeFromFile$MH = RuntimeHelper.downcallHandle(
        "NewtonDeserializeFromFile",
        constants$24.NewtonDeserializeFromFile$FUNC, false
    );
    static final FunctionDescriptor NewtonSerializeScene$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle NewtonSerializeScene$MH = RuntimeHelper.downcallHandle(
        "NewtonSerializeScene",
        constants$24.NewtonSerializeScene$FUNC, false
    );
}


