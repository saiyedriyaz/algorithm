package net.demo.challanges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * # # # # # # # # /TASK 1. Given a non-empty string s and a list wordList containing a list of non-empty tokens, determine if s can be represented as a
 * concatenation of tokens from the list (where each token may be used several times). You may assume the dictionary does not contain duplicate tokens.
 * # # # # # # #
 * # # # # #
 * # # # # #
 * # # # # #
 * # # # # # # # #
 * # # # # # # # # s = "whataniceday";
 * # # # # # # # # wordList = ["a", "what", "an", "nice", "day"];
 * # # # # # # # # -> true
 * # # # # # # # #
 * # # # # # # # # s = "dawhaty",
 * # # # # # # # # wordList = ["a", "what", "an", "nice", "day"].
 * # # # # # # # # -> false
 * # # # # # # # #
 * # # # # # # # # s = "abc",
 * # # # # # # # # wordList = ["a", "ab", "bc"].
 * # # # # # # # # -> true
 */
public class WordBreakSolution {

    private static Set<String> wordList = null;

    /**
     * arg[0] = comma sepearated word list for dictionary e.g. what,an,nice,day
     * arg[1] = word to be searched against dictionary e.g. whataniceday
     *
     * @param args
     */
    public static void main(String[] args) {
        String searchString = null;
        if (args != null && args.length == 2) {
            wordList = new HashSet<>(Arrays.asList(args[0].split(",")));
            searchString = args[1];
        }
        // run with sample/default test case
        else {
            wordList = new HashSet<>(Arrays.asList("what,an,nice,day".split(",")));
            searchString = "what";
        }

        boolean found = wordBreak(searchString);
        System.out.println("found all=" + found);

        EmployeeLog employeeLog = new EmployeeLog();
        employeeLog.age = 7;
    }

    /**
     * Returns true if the word can be represented as token that each token is part of dictionary
     *
     * @param word
     * @return
     */
    private static boolean wordBreak(String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 1; i <= word.length(); i++) {
            if (wordList.contains(word.substring(0, i)) && wordBreak(word.substring(i, word.length()))) {
                return true;
            }
        }

        return false;
    }

    static class EmployeeLog {
        Integer age = 5;

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
