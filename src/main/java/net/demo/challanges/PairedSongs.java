package net.demo.challanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

/**
 * @author Riyaz Saiyed
 */
public class PairedSongs {
    public static void main(String[] args) {
        // ArrayList data1 = new PairedSongs().IDsOfSongs(90, Arrays.asList(new
        // Integer[] { 1, 10, 25, 35, 60}));

        //ArrayList data2 = new PairedSongs().IDsOfSongs(250, Arrays.asList(new Integer[] { 100, 180, 40, 120, 10 }));

        // ArrayList data3 = new PairedSongs().IDsOfSongs(250, Arrays.asList(new
        // Integer[] { 180, 120, 100, 40, 10}));

        ArrayList data2 = new net.demo.challanges.PairedSongs().IDsOfSongs(250, Arrays.asList(new Integer[]{100}));

        System.err.println(data2);
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    ArrayList<Integer> IDsOfSongs(int rideDuration, List<Integer> songDurations) {

        SortedMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

        // check each element in array
        for (int i = 0; i < songDurations.size(); i++) {

            // check each other element in the array
            for (int j = i + 1; j < songDurations.size(); j++) {

                // determine if these two elements sum to rideDuration

                if (songDurations.get(i) + songDurations.get(j) == rideDuration - 30) {

                    ArrayList<Integer> pairList = new ArrayList<Integer>();

                    pairList.add(i);
                    pairList.add(j);

                    if (songDurations.get(i) > songDurations.get(j)) {
                        map.put(songDurations.get(i), pairList);
                    } else {
                        map.put(songDurations.get(j), pairList);
                    }
                }
            }
        }

        if (!map.isEmpty()) {
            return map.get(map.lastKey());
        }
        return new ArrayList<>();
    }

}