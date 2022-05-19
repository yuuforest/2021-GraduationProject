package 실습;

public class Prob220519 {

    public static double[][] P;
    public static double[][] D;

    public static void floyd(double[][] W) {

        int num = W.length;

        P = new double[num+1][num+1]; 
        D = new double[num+1][num+1];

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                P[i][j] = 0;
                D[i][j] = W[i-1][j-1];
            }
        }

        for (int k = 1; k <= num; k++) {
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= num; j++) {
                    if(D[i][k] + D[k][j] < D[i][j]) {
                        P[i][j] = k;
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
    }

    public static void path (int q, int r) {

        if (P[q][r] != 0) {
            path(q, (int)P[q][r]);
            System.out.print("v" + (int)P[q][r] + " -> ");
            path((int)P[q][r], r);
        }
    }
    
    public static void main(String[] args) {

        double posInf = Double.POSITIVE_INFINITY;

        double[][] weight = {{0, 1, posInf, 1, 5},
                            {9, 0, 3, 2, posInf},
                            {posInf, posInf, 0, 4, posInf},
                            {posInf, posInf, 2, 0, 3},
                            {3, posInf, posInf, posInf, 0}};

        floyd(weight);

        // D 행렬 출력

        System.out.println("D[i][j] is ");

        for (int i = 1; i < D.length; i++) {
            double[] inArr = D[i];
            
            for (int j = 1; j < inArr.length; j++) {
                System.out.print((int)inArr[j] + " ");
            }
            
            System.out.println();
        }

        // P 행렬 출력

        System.out.println("\nP[i][j] is ");

        for (int i = 1; i < P.length; i++) {
            double[] inArr = P[i];
            
            for (int j = 1; j < inArr.length; j++) {
                System.out.print((int)inArr[j] + " ");
            }
            
            System.out.println();
        }

        // PATH
        System.out.println();
        System.out.println();

        System.out.print("The shortest path(5, 3) is v5 -> ");
        path(5, 3);
        System.out.println("v3");

        System.out.println();

        System.out.print("The shortest path(1, 3) is v1 -> ");
        path(1, 3);
        System.out.println("v3");

        System.out.println();

        System.out.print("The shortest path(2, 5) is v2 -> ");
        path(2, 5);
        System.out.println("v5");

        System.out.println();
    }
}
