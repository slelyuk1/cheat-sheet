package com.leliuk.general.sort.impl;

import com.leliuk.general.sort.Sorter;
import com.leliuk.general.sort.SortersSuccessTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("Successful sorting tests for all implemented sorters with integer arrays")
class SortersByIntegerSuccessTest implements SortersSuccessTest<Integer, Integer> {

    private static final List<Sorter> TESTED_SORTERS = List.of(
            new BubbleSorter(),
            new InsertionSorter(),
            new SelectionSorter()
    );

    private static final List<Integer[]> UNSORTED_INT_ARRAYS = List.of(
            new Integer[]{},
            new Integer[]{1},
            new Integer[]{2, 1},
            new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
            new Integer[]{3, 6, 7, 11, 12, 13, 16, 17, 18, 19},
            new Integer[]{1, 2, 5, 8, 9, 10, 13, 14, 15, 18},
            new Integer[]{1, 3, 5, 6, 7, 10, 11, 12, 17, 18},
            new Integer[]{1, 3, 4, 5, 6, 8, 11, 12, 16, 20},
            new Integer[]{2, 4, 5, 6, 7, 10, 11, 13, 16, 17},
            new Integer[]{5, 6, 7, 12, 13, 14, 15, 17, 18, 19},
            new Integer[]{1, 3, 4, 10, 12, 14, 16, 17, 19, 20}
    );

    private static final List<Comparator<Integer>> INT_COMPARATORS = List.of(
            Comparator.naturalOrder(),
            Comparator.reverseOrder()
    );

    @Override
    @DisplayName("Array sorting with comparator is expected to be correct")
    @ParameterizedTest
    @MethodSource("sorterArrayAndComparatorProvider")
    public void sortInPlaceSuccessful(Sorter sorter, Integer[] checkedArray, Comparator<Integer> comparator) {
        SortersSuccessTest.super.sortInPlaceSuccessful(sorter, checkedArray, comparator);
    }

    @Override
    @DisplayName("Array sorting into copy with comparator is expected to be correct")
    @ParameterizedTest
    @MethodSource("sorterArrayAndComparatorProvider")
    public void sortToCopySuccessful(Sorter sorter, Integer[] checkedArray, Comparator<Integer> comparator) {
        SortersSuccessTest.super.sortToCopySuccessful(sorter, checkedArray, comparator);
    }

    @Override
    @DisplayName("Comparable array sorting is expected to be correct")
    @ParameterizedTest
    @MethodSource("sorterAndComparableArrayProvider")
    public void comparableSortInPlaceSuccessful(Sorter sorter, Integer[] checkedArray) {
        SortersSuccessTest.super.comparableSortInPlaceSuccessful(sorter, checkedArray);
    }

    @Override
    @DisplayName("Comparable array sorting into copy is expected to be correct")
    @ParameterizedTest
    @MethodSource("sorterAndComparableArrayProvider")
    public void comparableSortToCopySuccessful(Sorter sorter, Integer[] checkedArray) {
        SortersSuccessTest.super.comparableSortToCopySuccessful(sorter, checkedArray);
    }

    static Stream<Sorter> sorterProvider() {
        return TESTED_SORTERS.stream();
    }

    static Stream<Arguments> sorterArrayAndComparatorProvider() {
        return sorterProvider().flatMap(sorter ->
                UNSORTED_INT_ARRAYS.stream().flatMap(unsortedArray ->
                        INT_COMPARATORS.stream().map(comparator ->
                                Arguments.of(sorter, unsortedArray, comparator)
                        )
                )
        );
    }

    static Stream<Arguments> sorterAndComparableArrayProvider() {
        return sorterProvider().flatMap(sorter ->
                UNSORTED_INT_ARRAYS.stream().map(unsortedArray ->
                        Arguments.of(sorter, unsortedArray)
                )
        );
    }

}
