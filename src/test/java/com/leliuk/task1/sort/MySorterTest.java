package com.leliuk.task1.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class MySorterTest {
    private static final int ARR_LEN = 10000;
    private Random RAND = new Random();
    private int[] toSort;

    @Before
    public void init() {
        toSort = new int[ARR_LEN];
        for (int i = 0; i < ARR_LEN; ++i) {
            toSort[i] = RAND.nextInt();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void selectionSortMustThrowIllegalArgumentException() {
        MySorter.selectionSort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertionSortMustThrowIllegalArgumentException() {
        MySorter.insertionSort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bubbleSortMustThrowIllegalArgumentException() {
        MySorter.bubbleSort(null);
    }

    @Test
    public void selectionSortMustSortZeroSizeArray() {
        MySorter.selectionSort(new int[0]);
    }

    @Test
    public void insertionSortMustSortZeroSizeArray() {
        MySorter.insertionSort(new int[0]);
    }

    @Test
    public void bubbleSortMustSortZeroSizeArray() {
        MySorter.bubbleSort(new int[0]);
    }

    @Test
    public void mustSelectionSort() {
        int[] copy = Arrays.copyOf(toSort, toSort.length);
        MySorter.selectionSort(toSort);
        Arrays.sort(copy);
        assertArrayEquals(copy, toSort);
    }

    @Test
    public void mustInsertionSort() {
        int[] copy = Arrays.copyOf(toSort, toSort.length);
        MySorter.insertionSort(toSort);
        Arrays.sort(copy);
        assertArrayEquals(copy, toSort);
    }

    @Test
    public void mustBubbleSort() {
        int[] copy = Arrays.copyOf(toSort, toSort.length);
        MySorter.bubbleSort(toSort);
        Arrays.sort(copy);
        assertArrayEquals(copy, toSort);
    }
}
