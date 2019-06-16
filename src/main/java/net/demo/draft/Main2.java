package net.demo.draft;

import java.util.Arrays;

class Main2 {
    public static void main(String[] args) throws java.lang.Exception {
        // input:
        // l : string L
        // s : string s
        // Scanner in = new Scanner(System.in);
        String l = "17,12,11,102,23,97,13,8,4,34,66,12,88,45,67,23,51";// in.nextLine();
        String s = "209";// in.nextLine(); // expected 194

        // String l = "1,2,3,4,5";//in.nextLine();
        // String s = "7";//in.nextLine(); // expected 194

        String[] lStrs = l.split(",");
        Integer[] lInt = new Integer[lStrs.length];
        for (int i = 0; i < lStrs.length; i++) {
            lInt[i] = Integer.parseInt(lStrs[i]);
        }
        int sInt = Integer.parseInt(s);
        Arrays.sort(lInt);// , Collections.reverseOrder());
        // write your code here
        // store your results in `t`

        System.out.println("l=" + Arrays.asList(lInt));
        System.out.println("s=" + s);

        String t = getMaxNumberOfList(lInt, sInt) + "";

        // output
        System.out.println("found=" + t);
    }

    public static int getMaxNumberOfList(Integer set[], int sum) {
        int found = isSubsetSum(set, set.length, sum) ? 1 : 0;
        return found;
    }

    public static boolean isSubsetSum(Integer set[], int n, int sum) {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater 	than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        /*
         * else, check if sum can be obtained by any of the following (a) including the
         * last element (b) excluding the last element
         */
        return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }
}