package com.leliuk.task1.math;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class SequenceCalculatorTest {
    private SequenceCalculator calculator = new SequenceCalculator();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void iterativeFacMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.iterativeFac(-5);
    }

    @Test
    public void iterativeFac0MustReturn1() {
        assertEquals(1, calculator.iterativeFac(0));
    }

    @Test
    public void iterativeFac1MustReturn1() {
        assertEquals(1, calculator.iterativeFac(1));
    }

    @Test
    public void iterativeFac5MustReturn5() {
        assertEquals(120, calculator.iterativeFac(5));
    }

    @Test
    public void recursiveFacMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.recursiveFac(-5);
    }

    @Test
    public void recursiveFac0MustReturn1() {
        assertEquals(1, calculator.recursiveFac(0));
    }

    @Test
    public void recursiveFac1MustReturn1() {
        assertEquals(1, calculator.recursiveFac(1));
    }

    @Test
    public void recursiveFac5MustReturn5() {
        assertEquals(120, calculator.recursiveFac(5));
    }

    @Test
    public void bigFacMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.bigFac(-5);
    }

    @Test
    public void bigFac0MustReturn1() {
        assertEquals(BigInteger.ONE, calculator.bigFac(0));
    }

    @Test
    public void bigFac1MustReturn1() {
        assertEquals(BigInteger.ONE, calculator.bigFac(1));
    }

    @Test
    public void bigFac5MustReturn5() {
        assertEquals(BigInteger.valueOf(120), calculator.bigFac(5));
    }

    @Test
    public void bigFac20MustReturn2432902008176640000() {
        assertEquals(new BigInteger("2432902008176640000"), calculator.bigFac(20));
    }

    @Test
    public void iterativeFibMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.iterativeFib(-5);
    }

    @Test
    public void iterativeFib0MustReturn0() {
        assertEquals(0, calculator.iterativeFib(0));
    }

    @Test
    public void iterativeFib1MustReturn1() {
        assertEquals(1, calculator.iterativeFib(1));
    }

    @Test
    public void iterativeFib25MustReturn75025() {
        assertEquals(75025, calculator.iterativeFib(25));
    }

    @Test
    public void recursiveFibMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.recursiveFib(-5);
    }

    @Test
    public void recursiveFib0MustReturn0() {
        assertEquals(0, calculator.recursiveFib(0));
    }

    @Test
    public void recursiveFib1MustReturn1() {
        assertEquals(1, calculator.recursiveFib(1));
    }

    @Test
    public void recursiveFib25MustReturn75025() {
        assertEquals(75025, calculator.recursiveFib(25));
    }

    @Test
    public void bigFibMustThrowIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("N can't be negative !");
        calculator.bigFib(-5);
    }

    @Test
    public void bigFib0MustReturn0() {
        assertEquals(BigInteger.ZERO, calculator.bigFib(0));
    }

    @Test
    public void bigFib1MustReturn1() {
        assertEquals(BigInteger.ONE, calculator.bigFib(1));
    }

    @Test
    public void bigFib200MustReturn280571172992510140037611932413038677189525() {
        assertEquals(new BigInteger("280571172992510140037611932413038677189525"), calculator.bigFib(200));
    }
}
