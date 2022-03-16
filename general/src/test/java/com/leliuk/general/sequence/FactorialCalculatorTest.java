package com.leliuk.general.sequence;

import com.leliuk.general.sequence.impl.FactorialCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FactorialCalculatorTest implements SequenceCalculatorTest {

    private static final List<Integer> INVALID_NS = List.of(-1, -2, -3, -4, -5, -6);
    private static final Map<Integer, Number> N_TO_VALID_LONG_VALUE = Map.ofEntries(
            Map.entry(0, 1),
            Map.entry(1, 1),
            Map.entry(2, 2),
            Map.entry(3, 6),
            Map.entry(4, 24),
            Map.entry(5, 120),
            Map.entry(6, 720),
            Map.entry(7, 5040),
            Map.entry(8, 40320),
            Map.entry(9, 362880),
            Map.entry(10, 3628800),
            Map.entry(11, 39916800),
            Map.entry(12, 479001600),
            Map.entry(13, 6227020800L),
            Map.entry(14, 87178291200L),
            Map.entry(15, 1307674368000L),
            Map.entry(16, 20922789888000L),
            Map.entry(17, 355687428096000L),
            Map.entry(18, 6402373705728000L),
            Map.entry(19, 121645100408832000L),
            Map.entry(20, 2432902008176640000L)
    );

    private static final Map<Integer, Number> N_TO_VALID_BIG_VALUE =
            N_TO_VALID_LONG_VALUE.entrySet().stream().collect(Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> BigInteger.valueOf(entry.getValue().longValue())
            ));

    private final SequenceCalculator testedCalculator;

    public FactorialCalculatorTest() {
        this.testedCalculator = new FactorialCalculator();
    }

    @Override
    public SequenceCalculator getTestedCalculator() {
        return testedCalculator;
    }

    @Override
    @ParameterizedTest
    @MethodSource("invalidNSupplier")
    public void invalidNForBigIterativeShouldThrow(int invalidN) {
        SequenceCalculatorTest.super.invalidNForBigIterativeShouldThrow(invalidN);
    }

    @Override
    @ParameterizedTest
    @MethodSource("invalidNSupplier")
    public void invalidNForBigRecursiveShouldThrow(int invalidN) {
        SequenceCalculatorTest.super.invalidNForBigRecursiveShouldThrow(invalidN);
    }

    @Override
    @ParameterizedTest
    @MethodSource("invalidNSupplier")
    public void invalidNForIterativeShouldThrow(int invalidN) {
        SequenceCalculatorTest.super.invalidNForIterativeShouldThrow(invalidN);
    }

    @Override
    @ParameterizedTest
    @MethodSource("invalidNSupplier")
    public void invalidNForRecursiveShouldThrow(int invalidN) {
        SequenceCalculatorTest.super.invalidNForRecursiveShouldThrow(invalidN);
    }

    @Override
    @ParameterizedTest
    @MethodSource("nAndExpectedSequenceBigIntegerValueSupplier")
    public void bigIterativeShouldReturnExpected(int n, BigInteger expectedValue) {
        SequenceCalculatorTest.super.bigIterativeShouldReturnExpected(n, expectedValue);
    }

    @Override
    @ParameterizedTest
    @MethodSource("nAndExpectedSequenceBigIntegerValueSupplier")
    public void bigRecursiveShouldReturnExpected(int n, BigInteger expectedValue) {
        SequenceCalculatorTest.super.bigRecursiveShouldReturnExpected(n, expectedValue);
    }

    @Override
    @ParameterizedTest
    @MethodSource("nAndExpectedSequenceLongValueSupplier")
    public void iterativeShouldReturnExpected(int n, long expectedValue) {
        SequenceCalculatorTest.super.iterativeShouldReturnExpected(n, expectedValue);
    }

    @Override
    @ParameterizedTest
    @MethodSource("nAndExpectedSequenceLongValueSupplier")
    public void recursiveShouldReturnExpected(int n, long expectedValue) {
        SequenceCalculatorTest.super.recursiveShouldReturnExpected(n, expectedValue);
    }

    static Stream<Integer> invalidNSupplier() {
        return INVALID_NS.stream();
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
