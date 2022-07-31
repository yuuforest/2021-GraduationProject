package 학교수업.Sorting;

import java.util.Arrays;

public class BubbleSort1 {

    public static int[] Bubble(int unSorted[], int length){

        int temp = 0;

        for (int i = 0; i <= length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                if (unSorted[j] < unSorted[i]) {        // 올림차순
                    temp = unSorted[i];
                    unSorted[i] = unSorted[j];
                    unSorted[j] = temp;
                }
            }
        }
        
        return unSorted;
    }
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int[] unSortedArray = {13, 7, 9, 3, 11, 6, 12};
        int[] SortedArray = Bubble(unSortedArray, unSortedArray.length);

        sb.append(Arrays.toString(SortedArray));
        System.out.println(sb);

    }
}