package com.leliuk.general.sort;

import com.leliuk.general.utils.AbstractUtilityClass;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

// todo maybe refactor
public final class SortUtils extends AbstractUtilityClass {

    private SortUtils() {
        super();
    }

    public static void bubbleSort(@NotNull int[] arr) {
        Objects.requireNonNull(arr, "Array is expected to be non-null");
        final int len = arr.length;
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
    }

    public static void selectionSort(@NotNull int[] arr) {
        Objects.requireNonNull(arr, "Array is expected to be non-null");
        final int len = arr.length;
        for (int i = 0; i < len; ++i) {
            int min = arr[i];
            int minInd = i;
            for (int j = i + 1; j < len; ++j) {
                if (arr[j] < min) {
                    min = arr[j];
                    minInd = j;
                }
            }
            swap(arr, i, minInd);
        }
    }

    public static void insertionSort(@NotNull int[] arr) {
        Objects.requireNonNull(arr, "Array is expected to be non-null");
        for (int i = 1; i < arr.length; i++) {
            int toSwap = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > toSwap; --j) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = toSwap;
        }
    }

    private static void swap(@NotNull int[] a, @Min(0) int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
