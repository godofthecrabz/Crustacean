package main.engine.graphics;

public final class GraphConstants {

    public static final int FLOAT_SIZE_BYTES = 4;
    public static final int INT_SIZE_BYTES = 4;
    public static final int VECTOR3F_SIZE_BYTES = 3 * FLOAT_SIZE_BYTES;
    public static final int VECTOR4F_SIZE_BYTES = 4 * FLOAT_SIZE_BYTES;
    public static final int QUATF_SIZE_BYTES = 4 * FLOAT_SIZE_BYTES;
    public static final int MAT4X4_SIZE_FLOATS = 4 * 4;
    public static final int MAT4X4_SIZE_BYTES = MAT4X4_SIZE_FLOATS * FLOAT_SIZE_BYTES;
    public static final int MAX_LIGHTS = 10;
    public static final int SHADOW_MAP_CASCADE_COUNT = 3;

    private GraphConstants() {
        // Utility class
    }
}