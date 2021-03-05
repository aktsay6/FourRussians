import org.junit.jupiter.api.Assertions;

public class TestUtil {
    int[][] defaultMatrixMultiply(int[][] A, int[][] B) {
        int dim = A.length;
        int[][] result = new int[dim][dim];
        for (int i = 0; i < dim; i++)
        {
            for (int j = 0; j < dim; j++)
            {
                for (int k = 0; k < dim; k++)
                {
                    result[i][j] += A[i][k]*B[k][j];
                }
                if (result[i][j] > 0) {
                    result[i][j] = 1;
                }
            }
        }
        return result;
    }

    void assertMatrixEquals(int[][] first, int[][] second) {
        for (int i = 0; i < first.length; i++) {
            Assertions.assertArrayEquals(first[i], second[i]);
        }
    }
}
