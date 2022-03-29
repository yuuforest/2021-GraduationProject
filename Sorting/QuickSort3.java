package Sorting;

import java.util.Arrays;

// FIX 돌아가지를 않음 후

public class QuickSort3 {
    // 성능 향상 방법2
    // 작은 부분 화일의 경우 삽입 정렬 사용
    // 부분 화일의 크기가 일정 크기 이하로 작아지면 삽입 정렬 수행

    public static int[] Insertion(int unSorted[], int length) {

        int j = 0;
        int key = 0;

        for (int i = 1; i < length; i++) {
            key = unSorted[i];
            j = i - 1;

            // 배열의 시작이 0부터이기 때문에 0이 포함되어야 함
            while (j >= 0 && unSorted[j] > key) {       // 올림차순
                unSorted[j+1] = unSorted[j];
                j--;
            }
            unSorted[j+1] = key;
        }

        return unSorted;
    }

    public static int[] quick(int unSorted[], int start, int end) {
        
        int M = 15;     // 5에서 25까지

        if (start >= end) return unSorted;

        if ((end - start) <= M) return Insertion(unSorted, unSorted.length);

        else {
            int pivot = unSorted[end];
            int i = start - 1;
            int j = end;
            int temp = 0;

            for(;;) {
                
                while (unSorted[++i] < pivot);
                while (unSorted[--j] > pivot);
                
                if (i >= j) break;
                
                temp = unSorted[i];
                unSorted[i] = unSorted[j];
                unSorted[j] = temp;
            }

            temp = unSorted[i];
            unSorted[i] = unSorted[end];
            unSorted[end] = temp;

            quick(unSorted, start, i-1);
            quick(unSorted, i+1, end);
        }
        
        return unSorted;
    }
    public static void main(String[] args) throws Exception {
        
        StringBuilder sb = new StringBuilder();

        int[] unSortedArray1 = {13, 7, 9, 3, 11, 6, 12};
        int[] unSortedArray2 = {17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        sb.append(Arrays.toString(quick(unSortedArray1, 0, unSortedArray1.length - 1)) + "\n");
        sb.append(Arrays.toString(quick(unSortedArray2, 0, unSortedArray2.length - 1)) + "\n");

        System.out.println(sb);
    }
}
