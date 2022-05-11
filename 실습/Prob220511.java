package 실습;

import java.util.Arrays;

public class Prob220511 {
    public static void Maximum_Cheese (int[][] map) {

        int row = map.length;
        int column = map[0].length;

        int[][] BigCheese = new int[row][column];

        for (int i = row-2; i >= 0; i--) {  
            if (map[i][0] == -1) {              // 그냥 길
                BigCheese[i][0] = BigCheese[i+1][0];
            } else if (map[i][0] == 1) {        // 치즈
                BigCheese[i][0] = BigCheese[i+1][0] + 1;
            } else {    // map[i][0] == 2       // 쥐덫                
                break;
            }
        }

        for (int j = 1; j < column; j++) {
            if (map[row-1][j] == -1) {          // 그냥 길
                BigCheese[row-1][j] = BigCheese[row-1][j-1];
            } else if (map[row-1][j] == 1) {    // 치즈
                BigCheese[row-1][j] = BigCheese[row-1][j-1] + 1;
            } else {    // map[row-1][j] == 2   // 쥐덫             
                break;
            }
        }

        for (int i = row-2; i >= 0; i--) {
            for (int j = 1; j < column; j++) {
                if (map[i][j] == -1) {              // 그냥 길
                    BigCheese[i][j] = Math.max(BigCheese[i+1][j], BigCheese[i][j-1]);
                } else if (map[i][j] == 1) {        // 치즈
                    BigCheese[i][j] = Math.max(BigCheese[i+1][j], BigCheese[i][j-1]) + 1;
                } else {    // map[i][j] == 2       // 쥐덫
                    BigCheese[i][j] = -1;
                }
            }
        }

        System.out.println("Bigcheese : ");

        for (int i = 0; i < BigCheese.length; i++) {
            System.out.println(Arrays.toString(BigCheese[i]));
        }

        System.out.println();
        System.out.println("Maximum Cheese = " + BigCheese[0][column-1]);
        System.out.println();
    }

    
    
    public static void main(String[] args) {

        int[][] map = {{-1, -1, 1, -1, -1, -1, -1, -1, -1}, 
                        {-1, -1, -1, -1, -1, 1, -1, 2, -1}, 
                        {1, -1, 2, -1, -1, -1, -1, 1, -1}, 
                        {-1, -1, -1, -1, 1, 2, -1, -1, -1},
                        {-1, 1, -1, 1, -1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, 2, 1, 2, -1},
                        {-1, 1, -1, -1, 1, -1, -1, -1, -1},
                        {-1, -1,-1, -1, -1, 1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1, -1, -1, -1}};
        
        System.out.println("Map : ");

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        
        System.out.println();
        Maximum_Cheese(map);

    }
}
