package com.leliuk.sort;

public class MySorter {
    public static void sort(int[] arr) {
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
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }
    }
}
