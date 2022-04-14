package 실습;

public class Prob220413 {
    
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

    public static void kmp(String pattern, String text) {
        
        int plength = pattern.length();
        int tlength = text.length();

        int[] next = initNext(pattern);
        int i, j;

        for (i = 0, j = 0; i < tlength; i++, j++) {

            if (j == plength) {
                System.out.println("패턴이 발생한 위치: " + (i - plength));
                j = 0;
            }

            while ((j >= 0) && (text.charAt(i) != pattern.charAt(j))) {
                j = next[j];
            }
        }

        System.out.println("탐색 종료\n");
    }

    public static void main(String[] args) {

        // EXAMPLE 1
        System.out.println("Example1.");

        String text1 = "ababababcababababcaabbabababcaab";
        String pattern1 = "abababca";

        kmp(pattern1, text1);

        // EXAMPLE 2 

        System.out.println("Example2. ");

        String text2 = "This class is an algorithm design class. Therefore, students will have time to learn about algorithms and implement each algorithm themselves.";
        String pattern2 = "algorithm";

        kmp(pattern2, text2);  

        // FIX Pattern이 겹쳐서 나타나는 경우 찾지 못함 https://www.acmicpc.net/board/view/52492 (KMP 반례)

    }
}
