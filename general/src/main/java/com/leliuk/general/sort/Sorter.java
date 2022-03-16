package com.leliuk.general.sort;

import org.jetbrains.annotations.Nullable;

import java.util.Comparator;

public interface Sorter {

    <T> void sort(T @Nullable [] toSort, Comparator<T> comparator);

    default <T> T[] sortToCopy(T @Nullable [] toCopy, Comparator<T> comparator) {
        T[] toSort = copyArray(toCopy);
        sort(toSort, comparator);
        return toSort;
    }

    default <T extends Comparable<T>> void comparableSort(T @Nullable [] toSort) {
        sort(toSort, Comparator.naturalOrder());
    }

    default <T extends Comparable<T>> T[] comparableSortToCopy(T @Nullable [] toCopy) {
        T[] toSort = copyArray(toCopy);
        comparableSort(toSort);
        return toSort;
    }

    private static <T> T @Nullable [] copyArray(T @Nullable [] toCopy) {
        if (toCopy == null) {
            return null;
        }

        return toCopy.clone();
    }

}
