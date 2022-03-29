package Sorting;

import java.util.Arrays;

public class ShellSort2 {
    public static int[] Shell(int unSorted[], int length) {

        int[] gaps= {701, 301, 132, 57, 23, 10, 4, 1};
        int temp = 0, i = 0, j = 0;

        for (int k = gaps.length-1; k >= 0; k--) {

            int gap = gaps[k];

            if (gap > length) break;
            
            for (i = gap; i < length; i++) {

                temp = unSorted[i];

                for (j = i; j >= gap && unSorted[j-gap] > temp; j -= gap) {
                    unSorted[j] = unSorted[j - gap];
                }

                unSorted[j] = temp;
            }
        }

        return unSorted;
    }
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();

        int[] unSortedArray = {3, 14, 12, 4, 10, 13, 15, 5, 2, 7, 9, 6, 8, 11, 1};
        int[] SortedArray = Shell(unSortedArray, unSortedArray.length);

        sb.append(Arrays.toString(SortedArray));
        System.out.println(sb);
    }
}
