package 학교강의.Dynamic_Programming;

import java.util.Arrays;

public class Cheese_with_Traps {

    // [0][0]에서 시작하여 출구가 있는 [n-1][m-1]에 도달한다. 항상 오른쪽 또는 위쪽으로 이동 가능하며 최대한 치즈를 많이 먹자
    // 0 : 아무일 없음      1 : 치즈        2 : 덫

    public static void Maximum_Cheese (int[][] map) {

        int row = map.length;
        int column = map[0].length;

        int[][] BigCheese = new int[row][column];

        for (int i = row-2; i >= 0; i--) {
            if (map[i][0] == 0) {
                BigCheese[i][0] = BigCheese[i+1][0];
            } else if (map[i][0] == 1) {
                BigCheese[i][0] = BigCheese[i+1][0] + 1;
            } else {    // map[i][0] == 2                
                break;
            }
        }

        for (int j = 1; j < column; j++) {
            if (map[row-1][j] == 0) {
                BigCheese[row-1][j] = BigCheese[row-1][j-1];
            } else if (map[row-1][j] == 1) {
                BigCheese[row-1][j] = BigCheese[row-1][j-1] + 1;
            } else {    // map[i][0] == 2                
                break;
            }
        }

        for (int i = row-2; i >= 0; i--) {
            for (int j = 1; j < column; j++) {
                if (map[i][j] == 0) {
                    BigCheese[i][j] = Math.max(BigCheese[i+1][j], BigCheese[i][j-1]);
                } else if (map[i][j] == 1) {
                    BigCheese[i][j] = Math.max(BigCheese[i+1][j], BigCheese[i][j-1]) + 1;
                } else {    // map[i][j] == -2
                    BigCheese[i][j] = -1;
                }
            }
        }

        System.out.println("Bigcheese : ");

        for (int i = 0; i < BigCheese.length; i++) {
            System.out.println(Arrays.toString(BigCheese[i]));
        }

        System.out.println("Maximum Cheese = " + BigCheese[0][column-1]);
    }

    public static void main(String[] args) {

        int[][] map = {{0, 0, 1, 0, 0, 0, 0, 0, 0}, 
                        {0, 0, 0, 0, 0, 1, 0, 2, 0}, 
                        {1, 0, 2, 0, 0, 0, 0, 1, 0}, 
                        {0, 0, 0, 0, 1, 2, 0, 0, 0},
                        {0, 1, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 2, 1, 2, 0},
                        {0, 1, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        // int[][] map = {{0, 1, 0, 1, 1}, {0, 0, 2, 0, 0}, {0, 0, 1, 0, 0}};
        
        System.out.println("Map : ");

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        Maximum_Cheese(map);

    }
}