package net.demo.challanges;

public class FBQue2 {
    public static void main(String[] args) {
        // 1 2 3 4 5  - 3 is good 4,5 bad
        System.out.println(isSum(new int[]{1, 3, 5, 23}, 8));
        System.out.println(isSum(new int[]{1, 3, 5, 23, 2}, 7));
    }

    static boolean isSum(int[] arr, int targetSum) {
        boolean found = false;
        for (int i = 0; i < arr.length && !found; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (targetSum == arr[i] + arr[j]) {
                    found = true;
                }
            }
        }
        return found;
    }
}
