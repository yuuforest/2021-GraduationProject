package 학교강의.실습;

public class Prob220316_1 {

    public static void main(String[] args) throws Exception{

        // Cubic complexity n^3

        int[] countArray = {10, 50, 100, 150, 200};   // n       

        for (int num = 0; num < countArray.length; num++) {
            
            int n = countArray[num];
            int[][] a = new int[n][n];
            int[][] b = new int[n][n];
            int[][] c = new int[n][n];

            // 모든 행렬 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = 1;    // 곱할 대상 1    
                    b[i][j] = 1;    // 곱할 대상 2
                    c[i][j] = 0;    // 곱한 결과 
                }
            }

            long start = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    } 
                }
            }

            long end = System.currentTimeMillis();

            // 소요 시간 측정
            System.out.println("n이 " + countArray[num] + "일 경우, 수행시간 = " + (end - start) + " ms\n");
        }
        

    }
}
