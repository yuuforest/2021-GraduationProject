package 학교강의.Dynamic_Programming;

public class Pebble {

    public static void pebble(int[][] map) {

        int row = map.length;
        int column = map[0].length;

        int[][] mypebble = new int[row+1][column];

        for (int i = 0; i < mypebble.length; i++) {

            if (i == 3) mypebble[i][0] = map[0][0] + map[2][0];
            else mypebble[i][0] = map[i][0];
        }

        for (int i = 1; i < column; i++) {
            for (int j = 0; j < row+1; j++) {

                if (j==0) mypebble[0][i] = Math.max(mypebble[1][i-1], mypebble[2][i-1]) + map[0][i];
                else if (j==1) mypebble[1][i] = Math.max(mypebble[0][i-1], Math.max(mypebble[2][i-1], mypebble[3][i-1])) + map[1][i]; 
                else if (j==2) mypebble[2][i] = Math.max(mypebble[0][i-1], mypebble[1][i-1]) + map[2][i];
                else mypebble[3][i] = mypebble[1][i-1] + map[0][i] + map[2][i]; 
            }
        }

        for (int k = 0; k < mypebble.length; k++) {
            int[] inArr = mypebble[k];
            
            for (int l = 0; l < inArr.length; l++) {
                System.out.print(inArr[l] + " ");
            }
            
            System.out.println();
        }

    }

    public static void main(String[] args) {

        int[][] map = {{6, 7, 12, -5, 5, 3, 11, 3}, 
                        {-8, 10, 14, 9, 7, 13, 8, 5}, 
                        {11, 12, 7, 4, 8, -2, 9, 4}};

        // int[][] map = {{6, 7, 12, -5, 5}, 
        //                 {-8, 10, 14, 9, 7}, 
        //                 {11, 12, 7, 4, 8, -2}};

        pebble(map);

    }
    
}
