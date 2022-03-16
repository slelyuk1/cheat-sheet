package com.leliuk.general.sort;

import org.jetbrains.annotations.Nullable;

import java.util.Comparator;

public abstract class AbstractSorter implements Sorter {

    @Override
    public final <T> void sort(T @Nullable [] toSort, Comparator<T> comparator) {
        if (toSort == null) {
            return;
        }

        performSort(toSort, comparator);
    }

    @Override
    public final <T> T[] sortToCopy(T @Nullable [] toCopy, Comparator<T> comparator) {
        return Sorter.super.sortToCopy(toCopy, comparator);
    }

    @Override
    public final <T extends Comparable<T>> void comparableSort(T @Nullable [] toSort) {
        Sorter.super.comparableSort(toSort);
    }

    @Override
    public final <T extends Comparable<T>> T[] comparableSortToCopy(T @Nullable [] toCopy) {
        return Sorter.super.comparableSortToCopy(toCopy);
    }

    protected abstract <T> void performSort(T[] toSort,
                                            Comparator<T> comparator);

}
