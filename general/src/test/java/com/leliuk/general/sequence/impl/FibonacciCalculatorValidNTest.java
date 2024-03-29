package com.leliuk.general.sequence.impl;

import com.leliuk.general.sequence.SequenceCalculator;
import com.leliuk.general.sequence.SequenceCalculatorValidNTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("FibonacciCalculator tests with valid Ns")
class FibonacciCalculatorValidNTest implements SequenceCalculatorValidNTest {

    private static final Map<Integer, Number> N_TO_VALID_LONG_VALUE = Map.ofEntries(
            Map.entry(0, 0),
            Map.entry(1, 1),
            Map.entry(2, 1),
            Map.entry(3, 2),
            Map.entry(4, 3),
            Map.entry(5, 5),
            Map.entry(6, 8),
            Map.entry(7, 13),
            Map.entry(8, 21),
            Map.entry(9, 34),
            Map.entry(10, 55),
            Map.entry(11, 89),
            Map.entry(12, 144),
            Map.entry(13, 233),
            Map.entry(14, 377),
            Map.entry(15, 610),
            Map.entry(16, 987),
            Map.entry(17, 1597),
            Map.entry(18, 2584),
            Map.entry(19, 4181),
            Map.entry(20, 6765)
    );

    private static final Map<Integer, Number> N_TO_VALID_BIG_VALUE =
            N_TO_VALID_LONG_VALUE.entrySet().stream().collect(Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> BigInteger.valueOf(entry.getValue().longValue())
            ));

    private final SequenceCalculator testedCalculator;

    FibonacciCalculatorValidNTest() {
        this.testedCalculator = new FibonacciCalculator();
    }

    @Override
    public SequenceCalculator getTestedCalculator() {
        return testedCalculator;
    }

    @Override
    @DisplayName("'bigIterative' for valid N returns valid value")
    @ParameterizedTest
    @MethodSource("nAndExpectedSequenceBigIntegerValueSupplier")
    public void bigIterativeShouldReturnExpected(int n, BigInteger expectedValue) {
        SequenceCalculatorValidNTest.super.bigIterativeShouldReturnExpected(n, expectedValue);
    }

    @Override
    @DisplayName("'bigRecursive' for valid N returns valid value")
    @ParameterizedTest
    @MethodSource("nAndExpectedSequenceBigIntegerValueSupplier")
    public void bigRecursiveShouldReturnExpected(int n, BigInteger expectedValue) {
        SequenceCalculatorValidNTest.super.bigRecursiveShouldReturnExpected(n, expectedValue);
    }

    @Override
    @DisplayName("'iterative' for valid N returns valid value")
    @ParameterizedTest
    @MethodSource("nAndExpectedSequenceLongValueSupplier")
    public void iterativeShouldReturnExpected(int n, long expectedValue) {
        SequenceCalculatorValidNTest.super.iterativeShouldReturnExpected(n, expectedValue);
    }

    @Override
    @DisplayName("'recursive' for valid N returns valid value")
    @ParameterizedTest
    @MethodSource("nAndExpectedSequenceLongValueSupplier")
    public void recursiveShouldReturnExpected(int n, long expectedValue) {
        SequenceCalculatorValidNTest.super.recursiveShouldReturnExpected(n, expectedValue);
    }

    static Stream<Arguments> nAndExpectedSequenceLongValueSupplier() {
        return N_TO_VALID_LONG_VALUE.entrySet().stream()
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }

    static Stream<Arguments> nAndExpectedSequenceBigIntegerValueSupplier() {
        return N_TO_VALID_BIG_VALUE.entrySet().stream()
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }
}
