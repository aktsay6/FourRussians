public class Main {

    public static void main(String[] args) {

        int[][] A = {
                {0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0}
        };

        int[][] B = {
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 0, 0}
        };

        FourRussiansAlgorithm algorithm = new FourRussiansAlgorithm();

        int[][] C = algorithm.multiply(A, B);

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

    }
}
