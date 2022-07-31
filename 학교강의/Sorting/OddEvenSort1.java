package 학교수업.Sorting;

import java.util.Arrays;

// 8개 배열의 Sorting Network
// www.geeksforgeeks.org/odd-even-sort-brick-sort/

public class OddEvenSort1 {

    public static int[] OddEvenSort(int unSorted[], int length)
    {
        boolean isSorted = false; 
 
        while (!isSorted)
        {
            isSorted = true;
            int temp =0;
 
            // Odd
            for (int i=1; i<=length-2; i=i+2)
            {
                if (unSorted[i] > unSorted[i+1])
                {
                    temp = unSorted[i];
                    unSorted[i] = unSorted[i+1];
                    unSorted[i+1] = temp;
                    isSorted = false;
                }
            }
 
            // Even
            for (int i=0; i<=length-2; i=i+2)
            {
                if (unSorted[i] > unSorted[i+1])
                {
                    temp = unSorted[i];
                    unSorted[i] = unSorted[i+1];
                    unSorted[i+1] = temp;
                    isSorted = false;
                }
            }
        }
 
        return unSorted;
    }
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int[] unSortedArray = {13, 7, 9, 3, 11, 6, 12, 22};
        int[] SortedArray = OddEvenSort(unSortedArray, unSortedArray.length);

        sb.append(Arrays.toString(SortedArray));
        System.out.println(sb);

    }
}
