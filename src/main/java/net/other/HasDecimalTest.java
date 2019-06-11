package net.other;

/**
 *
 */

/**
 * @author S425401
 *
 */
public class HasDecimalTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        double d1 = 146909.99d;
        double d2 = -145899.0000d;
        System.err.println("has decimal =" + (d1 % 1 != 0) + " :: " + (d1 % 1));
        System.err.println("has decimal =" + (d2 % 1 != 0) + " :: " + (d2 % 1));

    }
}
