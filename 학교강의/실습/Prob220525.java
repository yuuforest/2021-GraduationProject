package 학교수업.실습;

public class Prob220525 {
    
    public static void main(String[] args) {

        // 입력 1
        int W1 = 15;
        int[] weight1 ={5, 10, 7, 3, 4, 11};
        int[] price1 = {5, 7, 10, 6, 8, 20};

        // 입력 2
        int W2 = 30;
        int[] weight2 ={3, 7, 8, 5, 6, 13, 11, 2};
        int[] price2 = {5, 7, 10, 6, 8, 20, 18, 5};

        System.out.println();
        System.out.println("입력 1에 대하여 가방에 담은 보석의 최대 가치: " + knapsack(weight1, price1, W1));
        System.out.println("입력 2에 대하여 가방에 담은 보석의 최대 가치: " + knapsack(weight2, price2, W2));
        System.out.println();
    }

    public static int knapsack(int[] weight, int price[], int W) {

        int length = weight.length;

        int[][] bag = new int[length+1][W+1];

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= W; j++) {
                if (weight[i-1] > j) bag[i][j] = bag[i-1][j];  
                else bag[i][j] = Math.max(bag[i-1][j-weight[i-1]] + price[i-1], bag[i-1][j]);
            }
        }

        return bag[length][W];
    }
}
