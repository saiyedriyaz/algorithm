package net.demo.challanges;

public class FBQue1 {
    public static void main(String[] args) {
        // 1 2 3 4 5  - 3 is good 4,5 bad
        System.out.println(getFirstBad(1, 5));
    }

    static boolean isBad(int rev) {
        if (rev <= 3) {
            return false;
        }
        return true;
    }

    static int getFirstBad(int good, int bad) {
        int working = 0;
        while (good <= bad) {

            int mid = (good + bad) / 2;
            if (!isBad(mid)) {
                working = mid;
                good = mid + 1;
            } else {
                bad = mid - 1;
            }
        }
        return working + 1;
    }
}
