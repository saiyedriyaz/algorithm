package net.demo.challanges;

public class LongestPelindrom {
    public static void main(String[] args) {
        System.out.println(">>" + new LongestPelindrom().longestPalindrome("abb")); // acdtopspotsdf
    }

    // sbabc cbabs
    // bbc cbb
    private String longest = "";

    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = helper(s, i, i);
            int len2 = helper(s, i, i + 1);
            int final_len = Math.max(len1, len2);
            if (final_len > end - start) {
                start = i - (final_len - 1) / 2;
                end = i + final_len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int helper(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public String longestPalindrome2(String s) {
        if (s != null && s.length() > 0) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = s.length(); j > i; j--) {
                    String toCheck = s.substring(i, j);
                    if (isPelindrom(toCheck) && toCheck.length() > longest.length()) {
                        longest = toCheck;
                    }
                }
            }
        }
        return longest;
    }

    private boolean isPelindrom(String s) {
        if (s != null) {
            StringBuilder b = new StringBuilder(s);
            return s.equals(b.reverse().toString());
        }
        return false;
    }
}