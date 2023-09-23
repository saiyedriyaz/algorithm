package knauf;

    public class ContiguousFragments {
        public static void main(String[] args) {
            System.out.println("Number of contiguous fragments with mean " + ": " +  countFragments(new int[]{2,1,3}, 2));
            System.out.println("Number of contiguous fragments with mean " + ": " +  countFragments(new int[]{0,4,3,-1}, 2));
            System.out.println("Number of contiguous fragments with mean " + ": " +  countFragments(new int[]{2,1,4}, 3));
        }

        public static int countFragments(int[] A, int S) {
            int count = 0;

            for (int i = 0; i < A.length; i++) {
                int sum = 0;
                int fragmentLength = 0;

                for (int j = i; j < A.length; j++) {
                    sum += A[j];
                    fragmentLength++;

                    if (sum == S * fragmentLength) {
                        count++;
                    }
                }
            }

            return count;
        }
    }

