package com.leliuk.task1.math;

import java.math.BigInteger;

public class SequenceCalculator implements FactorialCalculator, FibonacciCalculator {

    @Override
    public long iterativeFac(int n) {
        negativeCheck(n);
        long res = 1;
        for (int i = 1; i <= n; ++i) {
            res *= i;
        }

        return res;
    }

    @Override
    public long recursiveFac(int n) {
        negativeCheck(n);
        return n < 1 ? 1 : n * recursiveFac(n - 1);
    }

    @Override
    public BigInteger bigFac(int n) {
        negativeCheck(n);
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    @Override
    public long iterativeFib(int n) {
        negativeCheck(n);
        long left = 0, right = 1;
        for (int i = 1; i <= n; ++i) {
            long temp = left + right;
            left = right;
            right = temp;
        }
        return left;
    }

    @Override
    public long recursiveFib(int n) {
        negativeCheck(n);
        if (n == 0 || n == 1) {
            return n;
        }
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

    @Override
    public BigInteger bigFib(int n) {
        negativeCheck(n);
        BigInteger left = BigInteger.ZERO, right = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) {
            BigInteger temp = left.add(right);
            left = right;
            right = temp;
        }
        return left;
    }

    private static void negativeCheck(int n) throws ArithmeticException {
        if (n < 0) {
            throw new IllegalArgumentException("N can't be negative !");
        }
    }
}
