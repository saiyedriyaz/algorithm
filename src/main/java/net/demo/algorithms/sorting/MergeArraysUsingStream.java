package net.demo.algorithms.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeArraysUsingStream {

    public static void main(String[] args) {
        MergeArraysUsingStream mergeArrays = new MergeArraysUsingStream();
        int[] mergedArray = mergeArrays.mergeAndSort(new int[]
                {1, 1, 3, 5}, new int[]
                {1, 2, 3, 4});

        for (int i = 0; i < mergedArray.length; i++) {
            System.err.println(mergedArray[i]);
        }
    }

    public int[] mergeAndSort(int[] arrayA, int[] arrayB) {
        int[] mergedArray = IntStream.concat(Arrays.stream(arrayA), Arrays.stream(arrayB)).toArray();
        Arrays.sort(mergedArray);
        return mergedArray;
    }

}
