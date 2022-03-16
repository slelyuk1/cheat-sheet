package com.leliuk.general.sequence;

import org.junit.jupiter.api.Assertions;

import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.function.Function;

interface SequenceCalculatorTest {

    SequenceCalculator getTestedCalculator();

    default void invalidNForBigIterativeShouldThrow(int invalidN) {
        invalidNShouldThrow(getTestedCalculator()::bigIterative, invalidN);
    }

    default void invalidNForBigRecursiveShouldThrow(int invalidN) {
        invalidNShouldThrow(getTestedCalculator()::bigRecursive, invalidN);
    }

    default void invalidNForIterativeShouldThrow(int invalidN) {
        invalidNShouldThrow(getTestedCalculator()::iterative, invalidN);
    }

    default void invalidNForRecursiveShouldThrow(int invalidN) {
        invalidNShouldThrow(getTestedCalculator()::recursive, invalidN);
    }

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

    private void invalidNShouldThrow(Consumer<Integer> testedFunction,
                                     int invalidN) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                testedFunction.accept(invalidN)
        );
    }

    private void validNShouldReturnExpected(Function<Integer, Number> testedFunction,
                                            int n,
                                            Number expectedValue) {
        Number actualValue = testedFunction.apply(n);
        Assertions.assertEquals(expectedValue, actualValue);
    }

}
