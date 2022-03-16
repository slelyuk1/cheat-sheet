package com.leliuk.general.utils;

import javax.validation.constraints.Min;

public final class ArrayUtils extends AbstractUtilityClass {

    public static <T> void swap(T[] a, @Min(0) int i, @Min(0) int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private ArrayUtils() {
        super();
    }
}
