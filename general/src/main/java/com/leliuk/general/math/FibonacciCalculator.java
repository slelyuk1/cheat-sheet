package com.leliuk.general.math;

import com.leliuk.general.utils.CheckUtils;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

// todo how to annotate method most specifically
public class FibonacciCalculator implements SequenceCalculator {

    @Override
    public BigInteger bigIterative(@Min(0) int n) {
        CheckUtils.negativeCheck(n);
        BigInteger left = BigInteger.ZERO, right = BigInteger.ONE;
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

    private BigInteger innerBigRecursive(@NotNull BigInteger n) {
        if (BigInteger.ONE.compareTo(n) >= 0) {
            return n;
        }
        return innerBigRecursive(n.subtract(BigInteger.ONE)).add(innerBigRecursive(n.subtract(BigInteger.TWO)));
    }
}
