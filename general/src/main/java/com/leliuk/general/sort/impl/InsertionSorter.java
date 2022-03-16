package com.leliuk.general.sort.impl;

import com.leliuk.general.sort.AbstractSorter;

import java.util.Comparator;

public class InsertionSorter extends AbstractSorter {

    @Override
    protected <T> void performSort(T[] toSort, Comparator<T> comparator) {
        final int length = toSort.length;
        for (int i = 1; i < length; ++i) {
            T toSwap = toSort[i];
            int j;
            for (j = i - 1; j >= 0 && comparator.compare(toSort[j], toSwap) > 0; --j) {
                toSort[j + 1] = toSort[j];
            }
            toSort[j + 1] = toSwap;
        }
    }

}
