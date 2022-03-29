package Sorting;

import java.util.Arrays;

// FIX 0 부터 노드 계산되도록 수정 필요

public class HeapSort1 {

    public static void HeapSort(int unSorted[]) {

        int n = unSorted.length - 1;
        int temp = 0;

        for (int i = n/2; i >= 1; i--) {
            Heapify(unSorted, i, n);
        }

        for (int i = n-1; i >= 1; i--) {
            temp = unSorted[0];
            unSorted[0] = unSorted[i+1];
            unSorted[i+1] = temp;
            Heapify(unSorted, 0, i);
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

        int[] unSortedArray = {13, 7, 9, 3, 11, 6, 12};
        HeapSort(unSortedArray);

        sb.append(Arrays.toString(unSortedArray));
        System.out.println(sb);
    }
}
