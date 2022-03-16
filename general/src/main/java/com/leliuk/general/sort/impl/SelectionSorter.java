package com.leliuk.general.sort.impl;

import com.leliuk.general.sort.AbstractSorter;
import com.leliuk.general.utils.ArrayUtils;

import java.util.Comparator;

public class SelectionSorter extends AbstractSorter {

    @Override
    protected <T> void performSort(T[] toSort, Comparator<T> comparator) {
        final int length = toSort.length;
        for (int i = 0; i < length; ++i) {
            T min = toSort[i];
            int minInd = i;
            for (int j = i + 1; j < length; ++j) {
                if (comparator.compare(toSort[j], min) < 0) {
                    min = toSort[j];
                    minInd = j;
                }
            }
            ArrayUtils.swap(toSort, i, minInd);
        }
    }

}
