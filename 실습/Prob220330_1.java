package 실습;

import java.util.Arrays;

public class Prob220330_1 {

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

            // odd index가 실행될 때마다 실행된 결과를 출력 
            System.out.println("odd index:");
            System.out.println(Arrays.toString(unSorted));
 
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

            // even index가 실행될 때마다 실행된 결과를 출력 
            System.out.println("even index:");
            System.out.println(Arrays.toString(unSorted));
        }
    }

    public static void main(String[] args) {

        // 입력1. 첫번째 배열
        // int[] unSorted = {2, 10, 5, 3, 7, 9, 4, 10};

        // 입력2. 두번째 배열
        // int[] unSorted = {2, 1, 5, 3, 7, 9, 4, 10};

        // 입력3. 세번째 배열
        int[] unSorted = {4, 13, 2, 5, 6, 70, 8, 3, 10, 11, 24, 23, 21, 7, 9, 12};

        OddEvenSort(unSorted, unSorted.length);

        System.out.println("최종 정렬 결과");
        System.out.println(Arrays.toString(unSorted));

    }
}
