package Sorting;

import java.util.Arrays;

public class SelectionSort1 {

    static int[] Selection(int unSorted[], int length) {

        int smallest = 0;
        int temp = 0;

        for (int i = 0; i < length-1; i++) {
            smallest = i;

            for (int j = i+1; j < length; j++) {
                if(unSorted[j] < unSorted[smallest]) {      // 올림차순
                    smallest = j;
                }
            }

            temp = unSorted[i];
            unSorted[i] = unSorted[smallest];
            unSorted[smallest] = temp;
        }
           
        return unSorted;
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int[] unSortedArray = {13, 7, 9, 3, 11, 6, 12};
        int[] SortedArray = Selection(unSortedArray, unSortedArray.length);

        sb.append(Arrays.toString(SortedArray));
        System.out.println(sb);
    }
}
