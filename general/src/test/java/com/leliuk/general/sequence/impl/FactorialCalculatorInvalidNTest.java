package com.leliuk.general.sequence.impl;

import com.leliuk.general.sequence.SequenceCalculator;
import com.leliuk.general.sequence.SequenceCalculatorInvalidNTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("FactorialCalculator tests with invalid Ns")
public class FactorialCalculatorInvalidNTest implements SequenceCalculatorInvalidNTest {

    private static final List<Integer> INVALID_NS = List.of(-1, -2, -3, -4, -5, -6);

    private final SequenceCalculator testedCalculator;

    public FactorialCalculatorInvalidNTest() {
        this.testedCalculator = new FactorialCalculator();
    }

    @Override
    public SequenceCalculator getTestedCalculator() {
        return testedCalculator;
    }

    @Override
    @DisplayName("'bigIterative' method should throw if invalid N is passed")
    @ParameterizedTest
    @MethodSource("invalidNSupplier")
    public void invalidNForBigIterativeShouldThrow(int invalidN) {
        SequenceCalculatorInvalidNTest.super.invalidNForBigIterativeShouldThrow(invalidN);
    }

    @Override
    @DisplayName("'bigRecursive' method should throw if invalid N is passed")
    @ParameterizedTest
    @MethodSource("invalidNSupplier")
    public void invalidNForBigRecursiveShouldThrow(int invalidN) {
        SequenceCalculatorInvalidNTest.super.invalidNForBigRecursiveShouldThrow(invalidN);
    }

    @Override
    @DisplayName("'iterative' method should throw if invalid N is passed")
    @ParameterizedTest
    @MethodSource("invalidNSupplier")
    public void invalidNForIterativeShouldThrow(int invalidN) {
        SequenceCalculatorInvalidNTest.super.invalidNForIterativeShouldThrow(invalidN);
    }

    @Override
    @DisplayName("'recursive' should throw if invalid N is passed")
    @ParameterizedTest
    @MethodSource("invalidNSupplier")
    public void invalidNForRecursiveShouldThrow(int invalidN) {
        SequenceCalculatorInvalidNTest.super.invalidNForRecursiveShouldThrow(invalidN);
    }

    static Stream<Integer> invalidNSupplier() {
        return INVALID_NS.stream();
    }

}
