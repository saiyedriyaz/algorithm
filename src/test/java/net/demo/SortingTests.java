package net.demo;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import net.demo.algorithms.sorting.BubbleSort;
import net.demo.algorithms.sorting.MergeSort;

public class SortingTests {

	@Test
	public void mergeSortPositiveTest() {
	    int[] actual = { 5, 1, 6, 2, 3, 4 };
	    int[] expected = { 1, 2, 3, 4, 5, 6 };
	    MergeSort.sort(actual);
	    assertArrayEquals(expected, actual);
	}
	
	@Test
	public void bubbleSortPositiveTest() {
	    int[] actual = { 5, 1, 6, 2, 3, 4 };
	    int[] expected = { 1, 2, 3, 4, 5, 6 };
	    BubbleSort.sort(actual);
	    assertArrayEquals(expected, actual);
	}
}
