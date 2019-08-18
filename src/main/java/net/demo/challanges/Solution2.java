package net.demo.challanges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public static void main(String args[] ) throws Exception {
        String thisLine = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();

        while ((thisLine = br.readLine()) != null) {
            numbers.add(Integer.parseInt(thisLine));
        }

        Integer totalApples = numbers.get(0);
        Integer howManyMore = numbers.get(1);
        Integer difference = totalApples - howManyMore;
        Integer maddieHave = (difference / 2);
        Integer giaHave =  maddieHave + difference;
        System.out.println(giaHave);
        System.out.println(maddieHave);
    }
}