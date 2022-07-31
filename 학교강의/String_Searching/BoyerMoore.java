package 학교강의.String_Searching;

import java.io.FileNotFoundException;

public class BoyerMoore {

    public static int[] initSkip(String pattern) {
        
        int M = pattern.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        for (int i = 0; i < Character.MAX_VALUE; i++) {
            skip[i] = M;
        }

        for (int i = 0; i < M; i++) {
            skip[pattern.charAt(i)] = M - i - 1;
        }

        return skip;
    }

    public static int MisChar(String pattern, String text) {

        int M = pattern.length();
        int N = text.length();
        int i, j;

        int[] skip = initSkip(pattern);

        for (i = M-1, j = M-1; j >= 0; i--, j--) {
            while (text.charAt(i) != pattern.charAt(j)) {
                int k = skip[text.charAt(i)];

                if (M-j > k) i = i + M - j;
                else i = i + k;

                if (i >= N) return N;
                j = M -1;
            }
        }

        return i + 1;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        
        StringBuilder sb = new StringBuilder();

        String text = "The grass is always greener on the other side";
        String pattern = "greener";

        int check = MisChar(pattern, text);

        sb.append("Pattern 시작위치 : " + check + "\n");

        for (int i = check; i < check + pattern.length(); i++) {
            sb.append(text.charAt(i));
        }

        sb.append("\n");
        
        System.out.println(sb);
    }
}
