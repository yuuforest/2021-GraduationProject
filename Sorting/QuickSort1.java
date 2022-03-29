package Sorting;

import java.util.Arrays;

public class QuickSort1 {

    public static int[] quick(int unSorted[], int start, int end) {
        
        if (start >= end) return unSorted;

        int pivot = unSorted[end];
        int l = start;
        int r = end - 1;
        int temp = 0;

        while (l <= r) {    // 올림차순
            
            while (l <= r && unSorted[l] <= pivot) {
                l++;
            } 

            while (l <= r && unSorted[r] >= pivot) {
                r--;
            }

            if (l < r) {
                temp = unSorted[l];
                unSorted[l] = unSorted[r];
                unSorted[r] = temp;
            }
        }

        temp = unSorted[l];
        unSorted[l] = unSorted[end];
        unSorted[end] = temp;

        quick(unSorted, start, l-1);
        quick(unSorted, l+1, end);
        
        return unSorted;
    }
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();

        int[] unSortedArray = {13, 7, 9, 3, 11, 6, 12};
        int[] SortedArray = quick(unSortedArray, 0, unSortedArray.length - 1);

        sb.append(Arrays.toString(SortedArray));
        System.out.println(sb);
    }
}
