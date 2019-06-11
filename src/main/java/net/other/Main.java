package net.other;

import java.util.Arrays;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws java.lang.Exception {
        // input:
        // l : string L
        // s : string s
        // Scanner in = new Scanner(System.in);
        String l = "17,12,11,102,23,97,13,8,4,34,66,12,88,45,67,23,51";// in.nextLine();
        String s = "209";// in.nextLine(); // expected 194

        //String l = "1,2,3,4,5";//in.nextLine();
        //String s = "7";//in.nextLine(); // expected 194

        String[] lStrs = l.split(",");
        Integer[] lInt = new Integer[lStrs.length];
        for (int i = 0; i < lStrs.length; i++) {
            lInt[i] = Integer.parseInt(lStrs[i]);
        }
        int sInt = Integer.parseInt(s);
        Arrays.sort(lInt);//, Collections.reverseOrder());
        // write your code here
        // store your results in `t`

        System.out.println("l=" + Arrays.asList(lInt));
        System.out.println("s=" + s);

        String t = getMaxNumberOfList(lInt, sInt) + "";

        // output
        System.out.println("found=" + t);
    }

    public static int getMaxNumberOfList(Integer[] data, int sum) {
        int found = 0;
        if (data.length > 0 && sum > 0) {
            Arrays.sort(data, Collections.reverseOrder());
            for (int i = 0; i < data.length - 1; i++) {
                for (int j = 1; j < data.length; j++) {

                    int num1 = data[i];
                    int num2 = data[j];
                    if (num1 + num2 == sum) {
                        found++;
                    }
                }
            }

        }
        return found;
    }
}