package net.demo.algorithms.search;

public class BinarySearch {

    public static int search(int[] data, int element) {
        int index = -1;
        if (data.length > 0) {
            int left = 0;
            int right = data.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (data[mid] == element) {
                    index = mid;
                    break;
                } else if (data[mid] > element) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 8, 12, 16, 23, 38, 56, 72, 91}, 72));

    }
}
