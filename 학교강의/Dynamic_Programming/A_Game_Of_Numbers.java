package 학교수업.Dynamic_Programming;

import java.util.Arrays;

public class A_Game_Of_Numbers {

    public static int[][] game(int[][] array) {

        int row = array.length;
        int column = array[0].length;

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < column; j++) {

                if (j == 0) {
                    array[i][j] = Math.max(array[i-1][j], array[i-1][j+1]) + array[i][j]; 
                } else if (j == column - 1) {
                    array[i][j] = Math.max(array[i-1][j-1], array[i-1][j]) + array[i][j]; 
                } else {
                    array[i][j] = Math.max(Math.max(array[i-1][j-1], array[i-1][j]), array[i-1][j+1]) + array[i][j]; 
                }
            }
        } 

        return array;
    }
    
    public static void main(String[] args) {

        int[][] array = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

        array = game(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
