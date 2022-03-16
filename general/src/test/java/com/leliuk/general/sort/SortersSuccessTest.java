package com.leliuk.general.sort;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

public interface SortersSuccessTest<AnyType, ComparableType extends Comparable<ComparableType>> {

    default void sortInPlaceSuccessful(Sorter sorter,
                                       AnyType[] checkedArray,
                                       Comparator<AnyType> comparator) {
        sortInPlaceSuccessful(array -> sorter.sort(array, comparator), checkedArray, comparator);
    }

    default void comparableSortInPlaceSuccessful(Sorter sorter, ComparableType[] checkedArray) {
        sortInPlaceSuccessful(sorter::comparableSort, checkedArray, Comparator.naturalOrder());
    }

    default void sortToCopySuccessful(Sorter sorter,
                                      AnyType[] checkedArray,
                                      Comparator<AnyType> comparator) {
        sortToCopySuccessful(
                array -> sorter.sortToCopy(checkedArray, comparator), checkedArray, comparator
        );
    }

    default void comparableSortToCopySuccessful(Sorter sorter, ComparableType[] checkedArray) {
        sortToCopySuccessful(sorter::comparableSortToCopy, checkedArray, Comparator.naturalOrder());
    }

    private static <T> void sortInPlaceSuccessful(Consumer<T[]> testedFunction,
                                                  T[] array,
                                                  Comparator<T> comparator) {
        T[] toCheck = array.clone();
        testedFunction.accept(toCheck);
        Arrays.sort(array, comparator);
        Assertions.assertArrayEquals(array, toCheck);
    }

    private static <T> void sortToCopySuccessful(Function<T[], T[]> testedFunction,
                                                 T[] array,
                                                 Comparator<T> comparator) {
        T[] toCheck = testedFunction.apply(array);
        Assertions.assertNotSame(toCheck, array);
        Arrays.sort(array, comparator);
        Assertions.assertArrayEquals(array, toCheck);
    }


}