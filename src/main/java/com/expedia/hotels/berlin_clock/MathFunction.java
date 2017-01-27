package com.expedia.hotels.berlin_clock;

import java.util.function.IntFunction;

@FunctionalInterface
public interface MathFunction {

    int apply();

    static MathFunction remainder(int dividend, int divisor) {
        return () -> dividend % divisor;
    }

    static MathFunction quotient(int dividend, int divisor) {
        return () -> dividend / divisor;
    }

    static IntFunction<Boolean> lessThan(MathFunction function) {
        return index -> index < function.apply();
    }
}