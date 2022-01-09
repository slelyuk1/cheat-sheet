package com.leliuk.general.math;

import com.leliuk.general.utils.CheckUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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

    private BigInteger innerBigRecursive(@NotNull BigInteger n) {
        return BigInteger.ONE.compareTo(n) > 0 ? BigInteger.ONE : n.multiply(innerBigRecursive(n.subtract(BigInteger.ONE)));
    }
}
