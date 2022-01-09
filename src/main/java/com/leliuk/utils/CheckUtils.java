package com.leliuk.utils;

public final class CheckUtils extends AbstractUtilityClass {

    public static void negativeCheck(int n) throws ArithmeticException {
        if (n < 0) {
            throw new IllegalArgumentException("N can't be negative !");
        }
    }

    private CheckUtils() {
        super();
    }
}
