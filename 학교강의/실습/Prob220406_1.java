package 학교강의.실습;

public class Prob220406_1 {
    
    public static void HeapSort(int unSorted[], int check) {

        int n = unSorted.length - 1;
        int temp = 0;

        for (int i = n/2; i >= 1; i--) { 
            
            if (check == 0) {
                Heapify_Max(unSorted, i, n);
            } else {
                Heapify_Min(unSorted, i, n);
            }
            
        }

        for (int i = n-1; i >= 1; i--) {
            temp = unSorted[1];
            unSorted[1] = unSorted[i+1];
            unSorted[i+1] = temp;

            if (check == 0) {
                Heapify_Max(unSorted, 1, i);
            } else {
                Heapify_Min(unSorted, 1, i);
            }
        }
        
    }

    public static void Heapify_Min(int unSorted[], int h, int m) {
        int v = unSorted[h];
        int j = 0;

        for (j = 2*h; j <= m; j = 2*j) {
            
            if(j < m && unSorted[j] >= unSorted[j+1]) {
                j++;
            }

            if (v < unSorted[j]) {
                break;
            } else {
                unSorted[j/2] = unSorted[j];
            }
        }

        unSorted[j/2] = v;
    }

    public static void Heapify_Max(int unSorted[], int h, int m) {
        int v = unSorted[h];
        int j = 0;

        for (j = 2*h; j <= m; j = 2*j) {
            
            if(j < m && unSorted[j] < unSorted[j+1]) {
                j++;
            }

            if (v >= unSorted[j]) {
                break;
            } else {
                unSorted[j/2] = unSorted[j];
            }
        }

        unSorted[j/2] = v;
    }


    public static void main(String[] args) {

        int[] unSortedArray1 = {0, 6, 2, 8, 1, 3, 9, 4, 5, 10, 7};
        int[] unSortedArray2 = unSortedArray1;

        //////////////////////////////////////////////////////////

        System.out.print("\nMaxHeap 정렬 결과\n");

        HeapSort(unSortedArray1, 0);

        for (int i = 1; i < unSortedArray1.length; i++) {
            System.out.print(unSortedArray1[i] + " ");
        }

        //////////////////////////////////////////////////////////

        System.out.print("\nMinHeap 정렬 결과\n");

        HeapSort(unSortedArray2, 1);

        for (int i = 1; i < unSortedArray2.length; i++) {
            System.out.print(unSortedArray2[i] + " ");
        }

    }
}
