package 실습;

import java.util.Random;

public class Prob220330_2 {

    public static void OddEvenSort(int unSorted[], int length)
    {
        boolean isSorted = false; 
 
        while (!isSorted)
        {
            isSorted = true;
            int temp =0;
 
            // Odd
            for (int i=1; i<=length-1; i=i+2)
            {
                if (unSorted[i-1] > unSorted[i])
                {
                    temp = unSorted[i-1];
                    unSorted[i-1] = unSorted[i];
                    unSorted[i] = temp;
                    isSorted = false;
                }
            }
 
            // Even
            for (int i=2; i<=length-1; i=i+2)
            {
                if (unSorted[i-1] > unSorted[i])
                {
                    temp = unSorted[i-1];
                    unSorted[i-1] = unSorted[i];
                    unSorted[i] = temp;
                    isSorted = false;
                }
            }
        }
    }

    // 배열의 정렬 유무를 판단
    static void checkSort(int a[], int n) {
        boolean sorted = true;

        for (int i = 0; i < n-1; i++) {
            
            if (a[i] > a[i+1]) {    // 배열에서 앞의 수가 뒤의 수보다 크면
                sorted = false;     // 배열 오류 
            }

            if (!sorted) break;
        }

        if (sorted) {
            System.out.print("[정렬 완료]");
        } else {
            System.out.print("[정렬 오류]");
        }
    }

    public static void main(String[] args) {

        // 정렬할 배열의 크기를 설정한 배열
        int[] Ncount = {10000, 50000, 100000};

        Random ran = new Random();

        long start = 0, end = 0;

        // Ncount 배열 안에 있는 모든 크기에 대해서 실행
        for (int N : Ncount) {

            int[] RandomArray = new int[N];

            for (int i = 0; i < N; i++) {
                RandomArray[i] = ran.nextInt(1000);    // 0부터 1000까지의 난수 발생
            }

            // 시간 측정 시작
            start = System.currentTimeMillis();

            // 정렬
            OddEvenSort(RandomArray, RandomArray.length);

            // 시간 측정 종료
            end = System.currentTimeMillis();

            // 측정한 시간 출력
            System.out.print("\nN이 " + N + "일 경우, 수행시간 = " + (end - start) + " ms ");

            // 정렬의 상태 확인 : 정렬 완료 VS 정렬 오류
           checkSort(RandomArray, N);

           System.out.println();       // 깔끔한 출력을 위한  띄어쓰기

        }

        System.out.println();       // 깔끔한 출력을 위한  띄어쓰기

    }
    
}
