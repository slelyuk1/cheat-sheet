package com.leliuk.general.sequence;

import java.math.BigInteger;

public interface SequenceCalculator {

    BigInteger bigIterative(int n);

    BigInteger bigRecursive(int n);

    default long iterative(int n) {
        return bigIterative(n).longValueExact();
    }

    default long recursive(int n) {
        return bigRecursive(n).longValueExact();
    }
}
