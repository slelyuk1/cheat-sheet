package com.leliuk.general.sort;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;

// todo normal display names for tests
// todo private methods
interface AbstractSortersTest<AnyType, ComparableType extends Comparable<ComparableType>> {

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

    default void sortInPlaceSuccessful(Sorter sorter, AnyType[] array, Comparator<AnyType> comparator) {
        AnyType[] toCheck = array.clone();
        sorter.sort(toCheck, comparator);
        Arrays.sort(array, comparator);
        Assertions.assertArrayEquals(array, toCheck);
    }

    default void sortToCopySuccessful(Sorter sorter, AnyType[] array, Comparator<AnyType> comparator) {
        AnyType[] toCheck = sorter.sortToCopy(array, comparator);
        Assertions.assertNotSame(toCheck, array);
        Arrays.sort(array, comparator);
        Assertions.assertArrayEquals(array, toCheck);
    }

    default void comparableSortInPlaceSuccessful(Sorter sorter, ComparableType[] array) {
        ComparableType[] toCheck = array.clone();
        sorter.comparableSort(toCheck);
        Arrays.sort(array);
        Assertions.assertArrayEquals(array, toCheck);
    }

    default void comparableSortToCopySuccessful(Sorter sorter, ComparableType[] array) {
        ComparableType[] toCheck = sorter.comparableSortToCopy(array);
        Assertions.assertNotSame(toCheck, array);
        Arrays.sort(array);
        Assertions.assertArrayEquals(array, toCheck);
    }

}