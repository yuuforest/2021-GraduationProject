package 실습;

import java.util.Arrays;

public class Prob220504 {

    public static int[][] game(int[][] array) {

        int array_row = array.length;
        int array_column = array[0].length;

        for (int row = 1; row < array_row; row++) {
            for (int column = 0; column < array_column; column++) {

                int plusmax;

                if (column == 0) {
                    plusmax = Math.max(array[row-1][column], array[row-1][column+1]);
                } else if (column == array_column - 1) {
                    plusmax = Math.max(array[row-1][column-1], array[row-1][column]);
                } else {
                    plusmax = Math.max(Math.max(array[row-1][column-1], array[row-1][column]), array[row-1][column+1]);
                }

                System.out.print((row) + "행 : " + plusmax + " + " + array[row][column]);
                array[row][column] = plusmax + array[row][column];

                System.out.println(" = " + array[row][column]);
            }
        } 

        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        
        int max = array[array_row-1][0];

        for (int i = 1; i < array_column; i++) {

            if (max < array[array_row-1][i]) {
                max = array[array_row-1][i];
            }
        }

        System.out.println();
        System.out.println("최대값 = " + max);

        return array;
    }
    
    public static void main(String[] args) {

        int[][] array = {
            {3, 4, 9, -2, 2, 51, -23, 2, -1},
            {223, 7, 8, -11, 5, -99, 2, 3, -4},
            {2, 51, -23, -23, 6, 3, 2, 4, 5},
            {5, -99, 2, -1, 32, 2, 5, -99, 2},
            {6, 3, 3, -4, 2, -1, 6, 3, 3},
            {32, 2, 4, 5, 3, -4, 2, -1, 4},
            {4, 4, 23, 6, 2, -1, 3, -4, 34},
            {78, 32, 1, 7, 3, -4, -23, -23, 6},
            };

        array = game(array);
    }
}