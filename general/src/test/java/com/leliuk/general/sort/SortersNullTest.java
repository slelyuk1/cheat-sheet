package com.leliuk.general.sort;

import org.junit.jupiter.api.Assertions;

import java.util.Comparator;

public interface SortersNullTest {

    Comparator<?> DUMMY_COMPARATOR = Comparator.naturalOrder();

    default void sortNullArrayInPlaceIsExpectedToDoNothing(Sorter sorter) {
        sorter.sort(null, DUMMY_COMPARATOR);
    }

    default void sortNullArrayToCopyIsExpectedToReturnNull(Sorter sorter) {
        Object[] toCheck = sorter.sortToCopy(null, DUMMY_COMPARATOR);
        Assertions.assertNull(toCheck);
    }

    default void comparableSortNullArrayInPlaceIsExpectedToDoNothing(Sorter sorter) {
        sorter.comparableSort(null);
    }

    default void comparableSortNullArrayToCopyIsExpectedToReturnNull(Sorter sorter) {
        Object[] toCheck = sorter.comparableSortToCopy(null);
        Assertions.assertNull(toCheck);
    }

}