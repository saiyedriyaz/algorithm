package ing;

public class ASCIArt {
    public static void main(String[] args) {
        int height = 10; // adjust this value to change the height of the L

        // print the top of the L
        for (int i = 0; i < height - 1; i++) {
            System.out.println("L");
        }

        // print the bottom of the L
        for (int i = 0; i < height; i++) {
            System.out.print("L ");
        }
        ASCIArt r = new ASCIArt();
        r.solution(4);
    }
    public void solution(int N) {
        StringBuilder sb = new StringBuilder();
        // print the top of the L
        for (int i = 0; i < N - 1; i++) {
            sb.append("L\n");
        }
        // print the bottom of the L
        for (int i = 0; i < N; i++) {
            sb.append("L ");
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }
}
