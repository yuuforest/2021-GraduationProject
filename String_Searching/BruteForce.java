package String_Searching;

// 직선적 알고리즘 (naive) 
// Simple Matching Algorithm (단순 매칭) or Trivial Matching Algorithm (하찮은 매칭) or Linear Matching Algorithm (선형 매칭)
// : 한 글자 또는 한 비트씩 오른쪽으로 진행하며 테스트의 처음부터 끝까지 모두 비교하며 탐색하는 알고리즘

public class BruteForce {

    public static int Brute(String pattern, String text) {

        int plength = pattern.length();
        int tlength = text.length();

        int i, j;

        for (i = 0, j = 0; j < plength && i < tlength; i++, j++) {

            if (text.charAt(i) != pattern.charAt(j)) {
                i -= j;
                j = -1;
            }

        }

        if (j == plength) return (i - plength);

        return -1;
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        String text = "Brute-Force is easy?";
        String pattern = "Force";

        int start = Brute(pattern, text);

        sb.append(start);

        System.out.println(sb);
    }
}
