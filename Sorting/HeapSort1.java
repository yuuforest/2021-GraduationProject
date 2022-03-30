package Sorting;

import java.util.Arrays;

public class HeapSort1 {
    
    // 0이 아닌 1부터 시작하는 배열 정렬 

    public static void HeapSort(int unSorted[]) {

        int n = unSorted.length - 1;        // 9
        int temp = 0;

        for (int i = n/2; i >= 1; i--) {    // 4 부터
            Heapify(unSorted, i, n);
        }

        for (int i = n-1; i >= 1; i--) {
            temp = unSorted[1];
            unSorted[1] = unSorted[i+1];
            unSorted[i+1] = temp;
            Heapify(unSorted, 1, i);
        }
        
    }

    public static void Heapify(int unSorted[], int h, int m) {
        int v = unSorted[h];
        int j = 0;

        for (j = 2*h; j <= m; j = 2*j) {
            
            if(j < m && unSorted[j] < unSorted[j+1]) {
                j++;
            }

            if (v > unSorted[j]) {
                break;
            } else {
                unSorted[j/2] = unSorted[j];
            }
        }

        unSorted[j/2] = v;
    }


    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();

        int[] unSortedArray = {0, 6, 2, 8, 1, 3, 9, 4, 5, 10, 7};
        HeapSort(unSortedArray);

        sb.append(Arrays.toString(unSortedArray));
        System.out.println(sb);
    }
}
