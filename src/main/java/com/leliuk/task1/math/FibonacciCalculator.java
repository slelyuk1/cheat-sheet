package com.leliuk.task1.math;

import java.math.BigInteger;

public interface FibonacciCalculator {
    long iterativeFib(int n);

    long recursiveFib(int n);

    BigInteger bigFib(int n);
}
