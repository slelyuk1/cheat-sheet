package com.leliuk.general.sort.impl;

import com.leliuk.general.sort.Sorter;
import com.leliuk.general.sort.SortersNullTest;
import com.leliuk.general.sort.impl.BubbleSorter;
import com.leliuk.general.sort.impl.InsertionSorter;
import com.leliuk.general.sort.impl.SelectionSorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("Null tests for all implemented sorters")
public class AllSortersNullTest implements SortersNullTest {

    private static final List<Sorter> TESTED_SORTERS = List.of(
            new BubbleSorter(),
            new InsertionSorter(),
            new SelectionSorter()
    );

    @Override
    @DisplayName("Sorting of a null array in place with comparator should do nothing")
    @ParameterizedTest
    @MethodSource("sorterProvider")
    public void sortNullArrayInPlaceIsExpectedToDoNothing(Sorter sorter) {
        SortersNullTest.super.sortNullArrayInPlaceIsExpectedToDoNothing(sorter);
    }

    @Override
    @DisplayName("Sorting of a null array into a copy with comparator should return null")
    @ParameterizedTest
    @MethodSource("sorterProvider")
    public void sortNullArrayToCopyIsExpectedToReturnNull(Sorter sorter) {
        SortersNullTest.super.sortNullArrayToCopyIsExpectedToReturnNull(sorter);
    }

    @Override
    @DisplayName("Sorting of a null comparable array in place should do nothing")
    @ParameterizedTest
    @MethodSource("sorterProvider")
    public void comparableSortNullArrayInPlaceIsExpectedToDoNothing(Sorter sorter) {
        SortersNullTest.super.comparableSortNullArrayInPlaceIsExpectedToDoNothing(sorter);
    }

    @Override
    @DisplayName("Sorting of a null comparable array into a copy should return null")
    @ParameterizedTest
    @MethodSource("sorterProvider")
    public void comparableSortNullArrayToCopyIsExpectedToReturnNull(Sorter sorter) {
        SortersNullTest.super.comparableSortNullArrayToCopyIsExpectedToReturnNull(sorter);
    }

    static Stream<Sorter> sorterProvider() {
        return TESTED_SORTERS.stream();
    }

}
