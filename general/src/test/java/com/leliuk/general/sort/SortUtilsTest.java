package com.leliuk.general.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class SortUtilsTest {
    private static final int ARR_LEN = 10000;
    private static final Random RAND = new Random();

    private int[] toSort;

    @Before
    public void init() {
        toSort = new int[ARR_LEN];
        for (int i = 0; i < ARR_LEN; ++i) {
            toSort[i] = RAND.nextInt();
        }
    }

    // todo expected message
    @Test(expected = NullPointerException.class)
    public void selectionSortMustThrowIllegalArgumentException() {
        SortUtils.selectionSort(null);
    }

    // todo expected message
    @Test(expected = NullPointerException.class)
    public void insertionSortMustThrowIllegalArgumentException() {
        SortUtils.insertionSort(null);
    }

    // todo expected message
    @Test(expected = NullPointerException.class)
    public void bubbleSortMustThrowIllegalArgumentException() {
        SortUtils.bubbleSort(null);
    }

    @Test
    public void selectionSortMustSortZeroSizeArray() {
        SortUtils.selectionSort(new int[0]);
    }

    @Test
    public void insertionSortMustSortZeroSizeArray() {
        SortUtils.insertionSort(new int[0]);
    }

    @Test
    public void bubbleSortMustSortZeroSizeArray() {
        SortUtils.bubbleSort(new int[0]);
    }

    @Test
    public void mustSelectionSort() {
        int[] copy = Arrays.copyOf(toSort, toSort.length);
        SortUtils.selectionSort(toSort);
        Arrays.sort(copy);
        assertArrayEquals(copy, toSort);
    }

    @Test
    public void mustInsertionSort() {
        int[] copy = Arrays.copyOf(toSort, toSort.length);
        SortUtils.insertionSort(toSort);
        Arrays.sort(copy);
        assertArrayEquals(copy, toSort);
    }

    @Test
    public void mustBubbleSort() {
        int[] copy = Arrays.copyOf(toSort, toSort.length);
        SortUtils.bubbleSort(toSort);
        Arrays.sort(copy);
        assertArrayEquals(copy, toSort);
    }
}
