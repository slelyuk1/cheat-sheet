package com.leliuk.general.sort;

import com.leliuk.general.sort.impl.BubbleSorter;
import com.leliuk.general.sort.impl.InsertionSorter;
import com.leliuk.general.sort.impl.SelectionSorter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortersByIntegerTest implements AbstractSortersTest<Integer, Integer> {

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
    @ParameterizedTest
    @MethodSource("sorterProvider")
    public void sortNullArrayInPlaceIsExpectedToDoNothing(Sorter sorter) {
        AbstractSortersTest.super.sortNullArrayInPlaceIsExpectedToDoNothing(sorter);
    }

    @Override
    @ParameterizedTest
    @MethodSource("sorterProvider")
    public void sortNullArrayToCopyIsExpectedToReturnNull(Sorter sorter) {
        AbstractSortersTest.super.sortNullArrayToCopyIsExpectedToReturnNull(sorter);
    }

    @Override
    @ParameterizedTest
    @MethodSource("sorterProvider")
    public void comparableSortNullArrayInPlaceIsExpectedToDoNothing(Sorter sorter) {
        AbstractSortersTest.super.comparableSortNullArrayInPlaceIsExpectedToDoNothing(sorter);
    }

    @Override
    @ParameterizedTest
    @MethodSource("sorterArrayAndComparatorProvider")
    public void comparableSortNullArrayToCopyIsExpectedToReturnNull(Sorter sorter) {
        AbstractSortersTest.super.comparableSortNullArrayToCopyIsExpectedToReturnNull(sorter);
    }

    @Override
    @ParameterizedTest
    @MethodSource("sorterArrayAndComparatorProvider")
    public void sortInPlaceSuccessful(Sorter sorter, Integer[] array, Comparator<Integer> comparator) {
        AbstractSortersTest.super.sortInPlaceSuccessful(sorter, array, comparator);
    }

    @Override
    @ParameterizedTest
    @MethodSource("sorterArrayAndComparatorProvider")
    public void sortToCopySuccessful(Sorter sorter, Integer[] array, Comparator<Integer> comparator) {
        AbstractSortersTest.super.sortToCopySuccessful(sorter, array, comparator);
    }

    @Override
    @ParameterizedTest
    @MethodSource("sorterAndComparableArrayProvider")
    public void comparableSortInPlaceSuccessful(Sorter sorter, Integer[] array) {
        AbstractSortersTest.super.comparableSortInPlaceSuccessful(sorter, array);
    }

    @Override
    @ParameterizedTest
    @MethodSource("sorterAndComparableArrayProvider")
    public void comparableSortToCopySuccessful(Sorter sorter, Integer[] array) {
        AbstractSortersTest.super.comparableSortToCopySuccessful(sorter, array);
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
