package net.demo.draft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */

/**
 * @author S425401
 *
 */
public class ComparatorTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.add(-5l);
        list.add(5l);
        list.add(-2l);
        list.add(-15l);
        list.add(25l);

        System.err.println(list);

        Collections.sort(list, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        });

        System.err.println(list);
    }

}
