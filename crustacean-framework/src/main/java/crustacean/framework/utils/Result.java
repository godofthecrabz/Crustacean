package crustacean.framework.utils;

/**
 * Result type interface for representing an operation that may or may not fail.
 * @param <R>
 *     The return value of the operation.
 * @param <E>
 *     The error that caused the operation to fail.
 */
public sealed interface Result<R, E extends Throwable> {

    /**
     *
     * @param result
     * @param <R>
     * @param <E>
     */
    record Success<R, E extends Throwable>(R result) implements Result<R, E> {}

    /**
     *
     * @param error
     * @param <R>
     * @param <E>
     */
    record Failure<R, E extends Throwable>(E error) implements Result<R, E> {}
}
