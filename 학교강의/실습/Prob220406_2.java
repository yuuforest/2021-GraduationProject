package 학교강의.실습;

import java.util.Random;

public class Prob220406_2 {

    public static void HeapSort(int unSorted[], int check) {

        int n = unSorted.length - 1;
        int temp = 0;

        for (int i = n/2; i >= 1; i--) { 
            
            if (check == 0) {
                Heapify_Max(unSorted, i, n);
            } else {
                Heapify_Min(unSorted, i, n);
            }
            
        }

        for (int i = n-1; i >= 1; i--) {
            temp = unSorted[1];
            unSorted[1] = unSorted[i+1];
            unSorted[i+1] = temp;

            if (check == 0) {
                Heapify_Max(unSorted, 1, i);
            } else {
                Heapify_Min(unSorted, 1, i);
            }
        }
        
    }

    public static void Heapify_Min(int unSorted[], int h, int m) {
        int v = unSorted[h];
        int j = 0;

        for (j = 2*h; j <= m; j = 2*j) {
            
            if(j < m && unSorted[j] >= unSorted[j+1]) {
                j++;
            }

            if (v < unSorted[j]) {
                break;
            } else {
                unSorted[j/2] = unSorted[j];
            }
        }

        unSorted[j/2] = v;
    }

    public static void Heapify_Max(int unSorted[], int h, int m) {
        int v = unSorted[h];
        int j = 0;

        for (j = 2*h; j <= m; j = 2*j) {
            
            if(j < m && unSorted[j] < unSorted[j+1]) {
                j++;
            }

            if (v >= unSorted[j]) {
                break;
            } else {
                unSorted[j/2] = unSorted[j];
            }
        }

        unSorted[j/2] = v;
    }

    // 배열의 정렬 유무를 판단
    static void checkSort(int a[], int n, int check) {
        boolean sorted = true;

        for (int i = 1; i < n; i++) {

            if (check == 0) {
                if (a[i] > a[i+1]) {    // 배열에서 앞의 수가 뒤의 수보다 크면
                    sorted = false;     // 배열 오류 
                }
            } else {
                if (a[i] < a[i+1]) {    // 배열에서 뒤의 수가 앞의 수보다 크면
                    sorted = false;     // 배열 오류 
                }
            }

            if (!sorted) break;
        }

        if (sorted) {
            if (check == 0) {
                System.out.print("Maxheap Sorting complete!\n");
            }else {
                System.out.print("Minheap Sorting complete!\n");
            }   
        } else {
            if (check == 0) {
                System.out.print("Maxheap Sorting NOT complete!\n");
            }else {
                System.out.print("Minheap Sorting NOT complete!\n");
            }
        }
    }

    public static void main(String[] args) {
        
        // 정렬할 배열의 크기를 설정한 배열
        int[] Ncount = {10000, 50000, 100000, 500000, 1000000};

        Random ran = new Random();

        long start = 0, end = 0;

        // Ncount 배열 안에 있는 모든 크기에 대해서 실행
        for (int N : Ncount) {

            int[] RandomArray1 = new int[N+1];

            for (int i = 1; i < N+1; i++) {
                RandomArray1[i] = ran.nextInt(N);    // 0부터 1000까지의 난수 발생
            }

            int[] RandomArray2 = RandomArray1;

            //////////////////////////////////////////////////////////////////////

            start = System.currentTimeMillis();

            HeapSort(RandomArray1, 0);  // MaxHeap 정렬

            end = System.currentTimeMillis();

            checkSort(RandomArray1, N, 0);      // 정렬 상태 확인
            System.out.print("Maxheap Sorting (N=" + N + ") time cost : " + (end - start) + " ms\n");

            //////////////////////////////////////////////////////////////////////

            start = System.currentTimeMillis();

            HeapSort(RandomArray2, 1);  // MinHeap 정렬

            end = System.currentTimeMillis();

            checkSort(RandomArray2, N, 1);      // 정렬 상태 확인
            System.out.print("Minheap Sorting (N=" + N + ") time cost : " + (end - start) + " ms\n");

            //////////////////////////////////////////////////////////////////////

            System.out.println();       // 깔끔한 출력을 위한  띄어쓰기

        }

    }
}
