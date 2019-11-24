package net.demo.challanges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrefixSuffixScore {
    /*
     * Complete the 'calculateScore' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING text
     *  2. STRING prefixString
     *  3. STRING suffixString
     */
    public static String calculateScore(String text, String prefixString, String suffixString) {
        // Write your code here
        String subString = "";
        if (text != null && !text.trim().isEmpty()) {
            String prefixScore = calculatePrefixScore(text, prefixString);
            System.err.println("prefixScore=" + prefixScore);

            String suffixScore = calculateSufixScore(text, suffixString);
            System.err.println("suffixScore=" + suffixScore);

            int textScore = prefixScore.length() + suffixScore.length();
            if (textScore > 0) {
                String regexString = Pattern.quote(prefixScore) + "(.*?)" + Pattern.quote(suffixScore);
                Pattern pattern = Pattern.compile(regexString);
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()) {
                    String textInBetween = matcher.group(1);
                    subString = prefixScore + textInBetween + suffixScore;
                }
                else {
                    for(int i = 0; i< prefixScore.length();i++) {
                        if(suffixScore.contains(prefixScore.substring(i))) {
                            String temp = prefixScore.replace(prefixScore.substring(i), "");
                            subString = temp + suffixScore;
                            break;
                        }
                        else {
                            subString = suffixScore;
                        }
                    }
                }
            }
        }
        return subString;
    }

    private static String calculatePrefixScore(String text, String prefixString) {
        String longestString = "";
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j <= text.length(); j++) {
                String sub = text.substring(i, j);
                if (!sub.isEmpty() && prefixString.endsWith(sub)) {
                    //System.err.println(sub);
                    longestString = sub.length() > longestString.length() ? sub : longestString;
                }
            }
        }
        return longestString;
    }

    private static String calculateSufixScore(String text, String suffixString) {
        String longestString = "";
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j <= text.length(); j++) {
                String sub = text.substring(i, j);
                if (!sub.isEmpty() && suffixString.startsWith(sub)) {
                    //System.err.println(sub);
                    longestString = sub.length() > longestString.length() ? sub : longestString;
                }
            }
        }
        return longestString;
    }

    public static void main(String[] args) {
        //String o1 = calculateScore("engine", "raven", "ginkgo");
        //System.err.println(o1);

        //String o2 = calculateScore("nothing", "bruno", "ingenious");
        //System.err.println(o2);

        //String o3 = calculateScore("abracadabra", "habrahabr", "bracket");
        //System.err.println(o3);

        String o3 = calculateScore("ab", "b", "a");
        System.err.println(o3);
    }
}
