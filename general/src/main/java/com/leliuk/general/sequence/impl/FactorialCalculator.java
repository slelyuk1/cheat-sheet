package com.leliuk.general.sequence.impl;

import com.leliuk.general.sequence.SequenceCalculator;
import com.leliuk.general.utils.CheckUtils;

import javax.validation.constraints.Min;
import java.math.BigInteger;

public class FactorialCalculator implements SequenceCalculator {

    @Override
    public BigInteger bigIterative(@Min(0) int n) {
        CheckUtils.negativeCheck(n);
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    @Override
    public BigInteger bigRecursive(@Min(0) int n) {
        CheckUtils.negativeCheck(n);
        return innerBigRecursive(BigInteger.valueOf(n));
    }

    private BigInteger innerBigRecursive(BigInteger n) {
        if (BigInteger.ONE.compareTo(n) > 0) {
            return BigInteger.ONE;
        }
        return n.multiply(innerBigRecursive(n.subtract(BigInteger.ONE)));
    }
}
