package net.demo.challanges;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 1, 5};
        int[] test2 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int[] test3 = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 3, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 3};
        int[] test4 = {10, 29471, 5242, 21175, 28931, 2889, 7275, 19159, 21773, 1325, 6901};
        //Object[] output = findLongest();
        System.out.println(findLongest(test4));
       /* Object[] output = findLongest(test4);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }*/
    }

    // 0 4 12
    static int findLongest(int[] arr) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        if (arr.length > 0) {
            stack.push(arr[0]);
            Integer prevLast = arr[0];

            for (int i = 1; i < arr.length; i++) {
                if (stack.peek() < arr[i]) {
                    prevLast = stack.peek();
                    stack.push(arr[i]);
                } else if (stack.peek() > arr[i] && prevLast < arr[i]) {
                    stack.pop();
                    stack.push(arr[i]);
                }
            }
        }
        System.out.println("stack=" + stack);

        return stack.size();
    }
}