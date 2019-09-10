package com.leliuk.math;

import java.math.BigInteger;

public interface FactorialCalculator {
    long iterativeFac(int n);

    long recursiveFac(int n);

    BigInteger bigFac(int n);
}
