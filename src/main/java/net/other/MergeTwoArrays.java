package net.other;

/*
Write a function that will merge two arrays of sorted integers in a linear fashion. The output should be a sorted array containing all the elements from both input arrays, including any duplicates.
		For example, given these two arrays as arguments:
		[1,1,3,5], [1,2,3,4]
		Your function should return:
		[1,1,1,2,3,3,4,5]

*/
public class MergeTwoArrays {

    public static void main(String[] args) {
        int[] a = {1, 3, 3, 5, 9, 10};
        int[] b = {2, 10, 3, 7, 9};

        MergeTwoArrays array = new MergeTwoArrays();
        int[] r = array.mergeArrays(a, b);
        array.printIt(r);
    }

    public int[] mergeArrays(int[] arrayOne, int[] arrayTwo) {
        int[] mergedArray = new int[arrayOne.length + arrayTwo.length];
        int k = 0;
        for (int n : arrayOne) {
            mergedArray[k++] = n;
        }
        for (int n : arrayTwo) {
            mergedArray[k++] = n;
        }
        return removeDuplicates(mergedArray);
    }

    private int[] removeDuplicates(int[] mergedArray) {
        int len = mergedArray.length;
        for (int i = 0; i < len - 1; i++) {

            for (int j = i + 1; j < len; j++) {

                if (mergedArray[i] == mergedArray[j]) {

                    for (int k = j; k < len - 1; k++) {
                        mergedArray[k] = mergedArray[k + 1];
                    }
                    --len;
                }
            }
        }
        int[] r = new int[len];
        for (int i = 0; i < r.length; i++) {
            r[i] = mergedArray[i];
        }
        return r;
    }

    public void printIt(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1)
                System.out.print(",");
            else
                System.out.print("]");
        }
    }
}