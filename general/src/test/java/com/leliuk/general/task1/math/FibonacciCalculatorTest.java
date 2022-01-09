package com.leliuk.general.task1.math;

import com.leliuk.general.math.SequenceCalculator;
import com.leliuk.general.math.FibonacciCalculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

// todo tests for bigrecursive
public class FibonacciCalculatorTest {

    private final SequenceCalculator calculator = new FibonacciCalculator();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void iterativeFibMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.iterative(-5);
    }

    @Test
    public void iterativeFib0MustReturn0() {
        assertEquals(0, calculator.iterative(0));
    }

    @Test
    public void iterativeFib1MustReturn1() {
        assertEquals(1, calculator.iterative(1));
    }

    @Test
    public void iterativeFib25MustReturn75025() {
        assertEquals(75025, calculator.iterative(25));
    }

    @Test
    public void recursiveFibMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.recursive(-5);
    }

    @Test
    public void recursiveFib0MustReturn0() {
        assertEquals(0, calculator.recursive(0));
    }

    @Test
    public void recursiveFib1MustReturn1() {
        assertEquals(1, calculator.recursive(1));
    }

    @Test
    public void recursiveFib25MustReturn75025() {
        assertEquals(75025, calculator.recursive(25));
    }

    @Test
    public void bigFibMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.bigIterative(-5);
    }

    @Test
    public void bigFib0MustReturn0() {
        assertEquals(BigInteger.ZERO, calculator.bigIterative(0));
    }

    @Test
    public void bigFib1MustReturn1() {
        assertEquals(BigInteger.ONE, calculator.bigIterative(1));
    }

    @Test
    public void bigFib200MustReturn280571172992510140037611932413038677189525() {
        assertEquals(new BigInteger("280571172992510140037611932413038677189525"), calculator.bigIterative(200));
    }
}
