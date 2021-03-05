import org.junit.jupiter.api.Test;

public class BooleanMatrixMultiplyTest {

    private final TestUtil util = new TestUtil();

    @Test
    public void test2by2() {
        int[][] A = {
                {1, 1},
                {0, 0}
        };

        int[][] B = {
                {1, 0},
                {0, 1}
        };

        compareMatrixMultiplicationResults(A, B);
    }

    @Test
    public void test3by3() {
        int[][] A = {
                {1, 1, 0},
                {0, 0, 1},
                {0, 1, 0}
        };

        int[][] B = {
                {1, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        compareMatrixMultiplicationResults(A, B);
    }

    @Test
    public void test4by4() {
        int[][] A = {
                {1, 1, 0, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 1, 1}
        };

        int[][] B = {
                {1, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 1}
        };

        compareMatrixMultiplicationResults(A, B);
    }

    /**
     * In this case an additional row and column of zeros is added
     */
    @Test
    public void test5by5() {
        int[][] A = {
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1}
        };

        int[][] B = {
                {1, 0, 0, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0}
        };

        compareMatrixMultiplicationResults(A, B);
    }

    private void compareMatrixMultiplicationResults(int[][] first, int[][] second) {
        FourRussiansAlgorithm algorithm = new FourRussiansAlgorithm();

        int[][] solveResult = algorithm.multiply(first, second);
        int[][] defaultResult = util.defaultMatrixMultiply(first, second);

        util.assertMatrixEquals(solveResult, defaultResult);
    }
}
