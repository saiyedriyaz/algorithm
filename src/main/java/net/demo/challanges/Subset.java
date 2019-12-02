package net.demo.challanges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subset {
    public static void main(String[] args) {
        //List<String> subSets = allSubsets("abcabab"); //abcabab
        List<Set<String>> subSets2 = allSubsets2("abc");
        System.out.println(subSets2);
    }

    static List<String> allSubsets(String str) {
        List<String> subSets = new ArrayList<>();

        int len = str.length();
        int temp = 0;
        //Total possible subsets for string of size n is n*(n+1)/2
        String arr[] = new String[len * (len + 1) / 2];

        //This loop maintains the starting character
        for (int i = 0; i < len; i++) {
            //This loop adds the next character every iteration for the subset to form and add it to the array
            for (int j = i; j < len; j++) {
                arr[temp] = str.substring(i, j + 1);
                temp++;
            }
        }

        //This loop prints all the subsets formed from the string.
        System.out.println("All subsets for given string are: ");
        for (int i = 0; i < arr.length; i++) {
            subSets.add(arr[i]);
        }
        return subSets;
    }

    static List<Set<String>> allSubsets2(String str) {
        List<Set<String>> subSetList = new ArrayList<>();
        subSetList.add(new HashSet<>());

        for (int i = 0; i < str.length(); i++) {
            Set<String> sList = new HashSet<>();
            sList.add(str.charAt(i) + "");

            for (Set<String> set : subSetList) {
                set.add(str.charAt(i) + "");
            }
            subSetList.add(sList);
        }
        return subSetList;
    }
}
