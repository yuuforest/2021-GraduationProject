package 학교수업.Sorting;

import java.util.Arrays;

public class MergeSort1 {

    public static void mergesort(int unSorted[], int length) {

        int h = length / 2, m = length - h;
        int[] U = new int[h];
        int[] V = new int[m];

        if (length > 1) {
            
            for (int i = 0; i < h; i++) {
                U[i] = unSorted[i];
            }

            for (int j = 0; j < m; j++) {
                V[j] = unSorted[j+h];
            }

            mergesort(U, h);
            mergesort(V, m);
            merge(h, m, U, V, unSorted);
        }
    }

    public static void merge(int h, int m, int U[], int V[], int unSorted[]) {
        
        int i = 0, j = 0, k = 0;

        while (i < h && j < m) {        // 올림차순
            if (U[i] < V[j]) {
                unSorted[k] = U[i];
                i++;
            } else {
                unSorted[k] = V[j];
                j++;
            }
            k++;
        }

        if (i >= h) {
            while (j < m) {
                unSorted[k] = V[j];
                j++; k++;
            }
        } else {
            while (i < h) {
                unSorted[k] = U[i];
                i++; k++;
            }
        }
    }

    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();

        int[] unSortedArray = {13, 7, 9, 3, 11, 6, 12};
        mergesort(unSortedArray, unSortedArray.length);

        sb.append(Arrays.toString(unSortedArray));
        System.out.println(sb);
    }
    
}
