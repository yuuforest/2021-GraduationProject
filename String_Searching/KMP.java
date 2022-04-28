package String_Searching;

public class KMP {

    // 재시작 위치 알고리즘
    public static int[] initNext(String pattern) {

        int plength = pattern.length();

        int[] next = new int[plength];
        next[0] = -1;

        for (int i = 0, j = -1; i < plength; i++, j++) {
            
            // Original
            next[i] = j;

            // Better
            // if (j != -1) {
            //     next[i] = ((pattern.charAt(i) == pattern.charAt(j)) ? next[j] : j);
            // } else {
            //     next[i] = j;
            // }

            while ((j >= 0) && (pattern.charAt(i) != pattern.charAt(j))) {
                j = next[j];
            }
        }

        return next;
    }

    public static int kmp(String pattern, String text) {
        
        int plength = pattern.length();
        int tlength = text.length();

        int[] next = initNext(pattern);
        int i, j;

        for (i = 0, j = 0; j < plength && i < tlength; i++, j++) {
            while ((j >= 0) && (text.charAt(i) != pattern.charAt(j))) {
                j = next[j];
            }
        }

        if (j == plength) return (i - plength);
        else return i;
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        String text = "ababacabacaaba";
        String pattern = "caba";

        // initNext 함수로 Next 배열 출력
        // int[] nextTable = initNext(pattern);
        // sb.append(Arrays.toString(nextTable));

        // KMP
        int matching = kmp(pattern, text);
        sb.append("text[" + matching + "] = " + text.charAt(matching));

        // FIX 패턴이 겹쳐서 발생하는 경우 파악 불가능 해결 필요

        System.out.println(sb);

    }
}
