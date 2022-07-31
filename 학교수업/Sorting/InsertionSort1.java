package 학교수업.Sorting;

import java.util.Arrays;

public class InsertionSort1 {

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
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int[] unSortedArray = {13, 7, 9, 3, 11, 6, 12};
        int[] SortedArray = Insertion(unSortedArray, unSortedArray.length);

        sb.append(Arrays.toString(SortedArray));
        System.out.println(sb);
    }
}
