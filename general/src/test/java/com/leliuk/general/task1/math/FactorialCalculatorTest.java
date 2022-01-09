package com.leliuk.general.task1.math;

import com.leliuk.general.math.FactorialCalculator;
import com.leliuk.general.math.SequenceCalculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

// todo tests for bigrecursive
public class FactorialCalculatorTest {

    private final SequenceCalculator calculator = new FactorialCalculator();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void iterativeFacMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.iterative(-5);
    }

    @Test
    public void iterativeFac0MustReturn1() {
        assertEquals(1, calculator.iterative(0));
    }

    @Test
    public void iterativeFac1MustReturn1() {
        assertEquals(1, calculator.iterative(1));
    }

    @Test
    public void iterativeFac5MustReturn5() {
        assertEquals(120, calculator.iterative(5));
    }

    @Test
    public void recursiveFacMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.recursive(-5);
    }

    @Test
    public void recursiveFac0MustReturn1() {
        assertEquals(1, calculator.recursive(0));
    }

    @Test
    public void recursiveFac1MustReturn1() {
        assertEquals(1, calculator.recursive(1));
    }

    @Test
    public void recursiveFac5MustReturn5() {
        assertEquals(120, calculator.recursive(5));
    }

    @Test
    public void bigFacMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.bigIterative(-5);
    }

    @Test
    public void bigFac0MustReturn1() {
        assertEquals(BigInteger.ONE, calculator.bigIterative(0));
    }

    @Test
    public void bigFac1MustReturn1() {
        assertEquals(BigInteger.ONE, calculator.bigIterative(1));
    }

    @Test
    public void bigFac5MustReturn5() {
        assertEquals(BigInteger.valueOf(120), calculator.bigIterative(5));
    }

    @Test
    public void bigFac20MustReturn2432902008176640000() {
        assertEquals(new BigInteger("2432902008176640000"), calculator.bigIterative(20));
    }
}
