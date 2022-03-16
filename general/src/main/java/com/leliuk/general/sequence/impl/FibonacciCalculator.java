package com.leliuk.general.sequence.impl;

import com.leliuk.general.sequence.SequenceCalculator;
import com.leliuk.general.utils.CheckUtils;

import javax.validation.constraints.Min;
import java.math.BigInteger;

public class FibonacciCalculator implements SequenceCalculator {

    @Override
    public BigInteger bigIterative(@Min(0) int n) {
        CheckUtils.negativeCheck(n);
        BigInteger left = BigInteger.ZERO;
        BigInteger right = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) {
            BigInteger temp = left.add(right);
            left = right;
            right = temp;
        }
        return left;
    }

    @Override
    public BigInteger bigRecursive(@Min(0) int n) {
        CheckUtils.negativeCheck(n);
        return innerBigRecursive(BigInteger.valueOf(n));
    }

    private BigInteger innerBigRecursive(BigInteger n) {
        if (BigInteger.ONE.compareTo(n) >= 0) {
            return n;
        }
        BigInteger nMinusOne = innerBigRecursive(n.subtract(BigInteger.ONE));
        BigInteger nMinusTwo = innerBigRecursive(n.subtract(BigInteger.TWO));
        return nMinusOne.add(nMinusTwo);
    }
}
