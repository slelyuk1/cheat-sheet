package com.leliuk.math;

import java.math.BigInteger;

public interface FibonacciCalculator {
    long iterativeFib(int n);

    long recursiveFib(int n);

    BigInteger bigMathFib(int n);
}
