package net.demo.algorithms.sorting;

import java.util.Arrays;

public class CountingSort {

    static int[] countingSort(int arr[], int range) {
        int n = arr.length;

        // The result will store sorted array
        int result[] = new int[n];

        // Initialize count array with {range} as array contains elements from range 0 to range.
        int count[] = new int[range];
        for (int i = 0; i < range; ++i) {
            count[i] = 0;
        }

        // store count of each element in count array
        for (int i = 0; i < n; ++i) {
            ++count[arr[i]];
        }

        // Change count[i] so that count[i] now contains actual
        // position of this element in output array
        for (int i = 1; i <= 8; ++i) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < n; ++i) {
            result[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Before Sorting : ");
        int arr[] = {1, 4, 7, 3, 4, 5, 6, 3, 4, 8, 6, 4, 9};
        System.out.println(Arrays.toString(arr));
        arr = countingSort(arr, 10);
        System.out.println("=======================");
        System.out.println("After Sorting : ");
        System.out.println(Arrays.toString(arr));
    }
}
