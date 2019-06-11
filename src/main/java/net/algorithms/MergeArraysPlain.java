package net.algorithms;

public class MergeArraysPlain {

    public static void main(String[] args) {
        MergeArraysPlain mergeArrays = new MergeArraysPlain();
        int[] mergedArray = mergeArrays.mergeAndSort(new int[]
                {1, 1, 3, 5}, new int[]
                {1, 2, 3, 4});

        for (int i = 0; i < mergedArray.length; i++) {
            System.err.println(mergedArray[i]);
        }
    }

    public int[] mergeAndSort(int[] arrayA, int[] arrayB) {
        int[] mergedArray = new int[arrayA.length + arrayB.length];

        for (int i = 0; i < arrayA.length; i++) {
            mergedArray[i] = arrayA[i];
        }

        for (int i = 0; i < arrayB.length; i++) {
            mergedArray[i + arrayA.length] = arrayB[i];
        }

        bubbleSort(mergedArray);

        return mergedArray;
    }

    private void bubbleSort(int[] mergedArray) {
        int n = mergedArray.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < (n - i); j++) {
                if (mergedArray[j - 1] > mergedArray[j]) {
                    temp = mergedArray[j - 1];
                    mergedArray[j - 1] = mergedArray[j];
                    mergedArray[j] = temp;
                }
            }
        }
    }
}
