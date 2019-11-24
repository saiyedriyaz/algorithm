package net.demo.challanges;

import java.util.Arrays;

public class MinMaxWindowRiddle {
    public static void main(String[] args) {
        long or[] = riddle(new long[]{2, 6, 1, 12});
        for (long o : or) {
            System.out.print(o + " ");
        }
    }

    static long[] riddle(long[] arr) {
        if (arr.length == 0) {
            return new long[0];
        }
        long[] maxNoQueue = new long[arr.length];
        for (int windowSize = 1; windowSize <= arr.length; windowSize++) {
            long[] minOfWindowList = new long[arr.length];
            for (int i = 0; windowSize + i <= arr.length; i++) {
                Long minOfWindow = minOfAll(Arrays.copyOfRange(arr, i, windowSize + i));
                minOfWindowList[i] = minOfWindow;
            }
            maxNoQueue[windowSize - 1] = maxOfAll(minOfWindowList);
        }
        return maxNoQueue;
    }

    /*static long[] riddle(long[] arr) {
        if (arr.length == 0) {
            return new long[0];
        }
        long[] maxNoQueue = new long[arr.length];
        for (int windowSize = 1; windowSize <= arr.length; windowSize++) {
            long[] minOfWindowList = new long[arr.length];
            for (int i = 0; windowSize + i <= arr.length; i++) {
                Long minOfWindow = minOfAll(Arrays.copyOfRange(arr, i, windowSize + i));
                minOfWindowList[i] = minOfWindow;
            }
            maxNoQueue[windowSize - 1] = maxOfAll(minOfWindowList);
        }
        return maxNoQueue;
    }*/

    private static long minOfAll(long[] arr) {
        long min = arr[0];
        for (long a : arr) {
            if (a < min) {
                min = a;
            }
        }
        return min;
    }

    private static long maxOfAll(long[] arr) {
        long max = arr[0];
        for (long a : arr) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }

}
