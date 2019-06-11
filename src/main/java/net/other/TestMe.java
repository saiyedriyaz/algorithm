package net.other;

import java.util.Arrays;

/**
 *
 */

/**
 * @author S425401
 *
 */
public class TestMe {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int implementedLegs = 11764;
        int dividingFactor = implementedLegs > 1000 ? 250 : 25;
        int numberOFThreads = implementedLegs / dividingFactor;
        System.err.println("dividingFactor=" + dividingFactor);
        System.err.println("numberOFThreads=" + numberOFThreads);


        int[] data =
                {6, 13, 3, 2, 7, 9, 18, 4, 12, 1, 28, 22, 20, 5, 11, 27, 38, 15, 26, 14, 21, 40, 56, 16, 35, 30, 53, 46,
                        23, 6, 19, 10, 32, 57, 8, 47, 31, 51, 17, 37, 63, 24, 43, 65, 66, 39, 55, 50, 41, 29, 36, 60, 34,
                        33, 54, 64, 45, 48, 49, 44, 42, 61, 58, 52, 67, 25, 62, 68, 59};

        Arrays.sort(data);

        for (int datum : data) {
            System.err.println(datum);
        }

    }

}
