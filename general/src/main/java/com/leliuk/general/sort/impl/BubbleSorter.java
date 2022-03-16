package com.leliuk.general.sort.impl;

import com.leliuk.general.sort.AbstractSorter;
import com.leliuk.general.utils.ArrayUtils;

import java.util.Comparator;

public class BubbleSorter extends AbstractSorter {

    @Override
    protected <T> void performSort(T[] toSort, Comparator<T> comparator) {
        final int length = toSort.length;
        for (int i = 0; i < length - 1; ++i) {
            for (int j = 0; j < length - i - 1; j++) {
                T left = toSort[j];
                T right = toSort[j + 1];
                if (comparator.compare(left, right) > 0) {
                    ArrayUtils.swap(toSort, j, j + 1);
                }
            }
        }
    }

}
