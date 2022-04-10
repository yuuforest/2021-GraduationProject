package String_Searching;

import java.util.Arrays;

public class KMP {

    // 재시작 위치 알고리즘
    public static int[] initNext(String pattern) {

        int plength = pattern.length();

        int[] next = new int[plength];
        next[0] = -1;

        for (int i = 0, j = -1; i < plength; i++, j++) {
            next[i] = j;

            while ((j >= 0) && (pattern.charAt(i) != pattern.charAt(j))) {
                j = next[j];
            }
        }

        return next;
    }


    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        // String text = "ababacabacaaba";
        String pattern = "10100111";

        int[] nextTable = initNext(pattern);

        sb.append(Arrays.toString(nextTable));

        System.out.println(sb);

    }
}
