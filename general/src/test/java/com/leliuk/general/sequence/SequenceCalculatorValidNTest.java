package com.leliuk.general.sequence;

import org.junit.jupiter.api.Assertions;

import java.math.BigInteger;
import java.util.function.Function;

public interface SequenceCalculatorValidNTest {

    SequenceCalculator getTestedCalculator();

    default void bigIterativeShouldReturnExpected(int n, BigInteger expectedValue) {
        validNShouldReturnExpected(getTestedCalculator()::bigIterative, n, expectedValue);
    }

    default void bigRecursiveShouldReturnExpected(int n, BigInteger expectedValue) {
        validNShouldReturnExpected(getTestedCalculator()::bigRecursive, n, expectedValue);
    }

    default void iterativeShouldReturnExpected(int n, long expectedValue) {
        validNShouldReturnExpected(getTestedCalculator()::iterative, n, expectedValue);
    }

    default void recursiveShouldReturnExpected(int n, long expectedValue) {
        validNShouldReturnExpected(getTestedCalculator()::recursive, n, expectedValue);
    }

    private static void validNShouldReturnExpected(Function<Integer, Number> testedFunction,
                                            int n,
                                            Number expectedValue) {
        Number actualValue = testedFunction.apply(n);
        Assertions.assertEquals(expectedValue, actualValue);
    }

}
