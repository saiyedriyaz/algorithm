package knauf;

public class BananaDemo {
    public static int solution(String S) {
        // Implement your solution here
        int count = 0;
        if (S !=null && !S.isEmpty()) {
            char[] inputChars = S.toCharArray();
            outer: while(true) {
                char[] banana = "BANANA".toCharArray();
                for (int i = 0; i< banana.length; i++) {
                    for (int j = 0; j < inputChars.length; j++) {
                        if (banana[i] == inputChars[j]) {
                            banana[i] = ' ';
                            inputChars[j] = ' ';
                            break;
                        }
                    }
                }
                if(String.valueOf(banana).trim().isEmpty()) {
                    count++;
                    banana = "BANANA".toCharArray();
                    if(String.valueOf(inputChars).replace(" ", "").trim().length() < banana.length) {
                        break outer;
                    }
                }
                else {
                    break outer;
                }
                //System.out.println(new String(inputChars));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(solution("NAABXXAN"));
        //System.out.println(solution("NAANAAXNABABYNNBZ"));
        System.out.println(solution(null));

        //solution("NAANAAXNABABYNNBZ");
    }
}
