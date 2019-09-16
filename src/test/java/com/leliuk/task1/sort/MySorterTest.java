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
    public void selectionSortShouldThrowIllegalArgumentException() {
        MySorter.selectionSort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertionSortShouldThrowIllegalArgumentException() {
        MySorter.insertionSort(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bubbleSortShouldThrowIllegalArgumentException() {
        MySorter.bubbleSort(null);
    }

    @Test
    public void selectionSortShouldSortZeroSizeArray() {
        MySorter.selectionSort(new int[0]);
    }

    @Test
    public void insertionSortShouldSortZeroSizeArray() {
        MySorter.insertionSort(new int[0]);
    }

    @Test
    public void bubbleSortShouldSortZeroSizeArray() {
        MySorter.bubbleSort(new int[0]);
    }

    @Test
    public void shouldSelectionSort() {
        int[] copy = Arrays.copyOf(toSort, toSort.length);
        MySorter.selectionSort(toSort);
        Arrays.sort(copy);
        assertArrayEquals(copy, toSort);
    }

    @Test
    public void shouldInsertionSort() {
        int[] copy = Arrays.copyOf(toSort, toSort.length);
        MySorter.insertionSort(toSort);
        Arrays.sort(copy);
        assertArrayEquals(copy, toSort);
    }

    @Test
    public void shouldBubbleSort() {
        int[] copy = Arrays.copyOf(toSort, toSort.length);
        MySorter.bubbleSort(toSort);
        Arrays.sort(copy);
        assertArrayEquals(copy, toSort);
    }
}
