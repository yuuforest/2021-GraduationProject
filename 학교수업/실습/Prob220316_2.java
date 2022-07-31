package 학교수업.실습;

public class Prob220316_2 {

    static int Fibonacci(int n) { 

        if (n == 0) return 0;
        if (n == 1) return 1;

        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    public static void main(String[] args) {

        // Exponential complexity 2^n : 최적화되지 않은 피보나치 수열 (재귀)
        
        int[] countArray = {10, 20, 30, 40, 50};

        for (int num = 0; num < countArray.length; num++) {
            
            int n = countArray[num];

            long start = System.currentTimeMillis();

            Fibonacci(n);

            long end = System.currentTimeMillis();

            // 소요 시간 측정
            System.out.println("n이 " + countArray[num] + "일 경우, 수행시간 = " + (end - start) + " ms\n");
        }
    }
}


