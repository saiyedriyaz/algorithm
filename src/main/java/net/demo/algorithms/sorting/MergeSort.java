package net.demo.algorithms.sorting;

//Implementation of Merge Sort Algorithm in Java

public class MergeSort {
    // merge the two sorted arrays
    private static void merge(int[] array, int low, int mid, int high) {
        int i, j, k;
        int[] c = new int[high - low + 1];
        k = 0;
        i = low;
        j = mid + 1;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                c[k++] = array[i++];
            } else {
                c[k++] = array[j++];
            }
        }
        while (i <= mid) {
            c[k++] = array[i++];
        }
        while (j <= high) {
            c[k++] = array[j++];
        }
        k = 0;
        for (i = low; i <= high; i++) {
            array[i] = c[k++];
        }
    }

    // merge sort implementaion
    private static void mergeSort(int[] array, int low, int high) {
        if (high - low + 1 > 1) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }
}