package com.leliuk.general.sequence;

import org.junit.jupiter.api.Assertions;

import java.util.function.Consumer;

public interface SequenceCalculatorInvalidNTest {

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

    private void invalidNShouldThrow(Consumer<Integer> testedFunction,
                                     int invalidN) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                testedFunction.accept(invalidN)
        );
    }
}
