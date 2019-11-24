package net.demo.challanges;

public class RepeatedString {
    public static void main(String[] args) {
        //System.err.println(repeatedString("aba", 10));
        System.err.println(repeatedString("ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt", 685118368975L));
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long aCountInS = findACount(s);

        long mod = n % s.length();
        System.out.println("mod=" + mod);
        long aCount = (n / s.length()) * aCountInS;
        System.out.println("aCount=" + aCount);

        long newIndex = s.length() - mod;
        String newS = s.substring(0, (int) mod);
        long totalACcount = aCount + findACount(newS);
        return totalACcount;
    }

    static long findACount(String s) {
        char[] sChars = s.toCharArray();
        long aCountInS = 0;
        for (char sChar : sChars) {
            if ('a' == sChar) {
                aCountInS++;
            }
        }
        return aCountInS;
    }
}
