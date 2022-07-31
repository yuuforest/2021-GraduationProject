package 학교강의.Sorting;

import java.util.Arrays;

public class ShellSort1 {

    public static int[] Shell(int unSorted[], int length) {

        int h = 0, v = 0, j = 0;

        for (h = 1; h < length; h = 3*h +1) {}  // 1, 4, 13

        for ( ; h > 0; h = h/3) {              // 13 -> 4 -> 1
            for (int i = h; i < length; i++) {  // 13 -> 14
                v = unSorted[i];
                j = i;

                while (j >= h && unSorted[j-h] > v) {
                    unSorted[j] = unSorted[j-h];
                    j -= h;
                }

                unSorted[j] = v;
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
