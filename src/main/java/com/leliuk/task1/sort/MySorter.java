package com.leliuk.task1.sort;

public final class MySorter {

    private MySorter() throws InstantiationException {
        throw new InstantiationException("Can't instantiate utility class !");
    }

    public static void bubbleSort(int[] arr) {
        checkNullValue(arr);
        final int len = arr.length;
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
    }

    public static void selectionSort(int[] arr) {
        checkNullValue(arr);
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

    public static void insertionSort(int[] arr) {
        checkNullValue(arr);
        for (int i = 1; i < arr.length; i++) {
            int toSwap = arr[i];
            int j;
            for (j = i - 1; j >= 0 && arr[j] > toSwap; --j) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = toSwap;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void checkNullValue(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException("You can't pass null array to method");
    }
}
