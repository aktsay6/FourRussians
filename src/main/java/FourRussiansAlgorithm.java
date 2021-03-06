import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourRussiansAlgorithm {
    private final Logger logger = Logger.getLogger(FourRussiansAlgorithm.class);

    private final List<int[][]> partsOfA = new ArrayList<>();
    private final List<int[][]> partsOfB = new ArrayList<>();

    int[][] multiply(int[][] A, int[][] B) {
        int dim = A.length;
        double m = Math.floor(Util.log2(dim));

        logger.debug("Matrices dimensions are " + dim);

        logger.debug("Beginning to preprocess matrices");
        preprocessing(A, B, m);

        int[][] result = Util.createMatrix(dim, dim);

        logger.debug("Beginning to multiply matrices");
        for (int i = 0; i < (int)Math.ceil(dim / m); i++) {
            int[][] RS = Util.createMatrix(Util.intPow(2, (int)m), dim);
            int bp = 1, k = 0;
            for (int j = 1; j < Util.intPow(2, (int)m); j++) {
                RS[j] = Util.sumRows(RS[j - Util.intPow(2, k)], Util.rowFromBottom(partsOfB.get(i), k));
                if (bp == 1) {
                    bp = j + 1;
                    k++;
                } else {
                    bp--;
                }
            }
            int[][] tmp = Util.createMatrix(dim, dim);
            for (int j = 0; j < dim; j++) {
                tmp[j] = RS[Util.getDecimalNumber(partsOfA.get(i)[j])];
            }

            result = Util.matrixSum(result, tmp);
        }
        logger.debug("Returning result matrix");
        return result;
    }


    private void preprocessing(int[][] A, int[][] B, double m) {
        int n = A.length;
        int numberOfParts = (int)Math.ceil(n / m);

        logger.debug("Dividing matrices by " + numberOfParts + " rows/columns");

        for (int i = 0; i < numberOfParts; i++) {
            addPartOfA(A, m, i * (int)m);
            addPartOfB(B, m, i * (int)m);
        }
    }

    /**
     * Fills A array with columns of A's matrix
     *
     * @param A inital matrix
     * @param m number of columns
     * @param startIndex number of current column
     */
    private void addPartOfA(int[][] A, double m, int startIndex) {
        logger.debug("Adding another part of A matrix to list");
        int[][] tmpMatrix = new int[A.length][(int)m];
        for (int column = 0; column < m; column++) {
            int[] tmpColumn = Util.getRowOrColumn(A, startIndex + column, false);
            for (int row = 0; row < A.length; row++) {
                tmpMatrix[row][column] = tmpColumn[row];
            }

        }
        partsOfA.add(tmpMatrix);
        logger.debug("Added matrix:\n" +
                Arrays
                    .stream(tmpMatrix)
                    .map(Arrays::toString)
                    .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    private void addPartOfB(int[][] B, double m, int startIndex) {
        logger.debug("Adding another part of B matrix to list");
        int[][] tmpMatrix = new int[(int)m][B.length];
        for (int row = 0; row < m; row++) {
            tmpMatrix[row] = Util.getRowOrColumn(B, startIndex + row, true);
        }
        partsOfB.add(tmpMatrix);
        logger.debug("Added matrix:\n" +
                Arrays
                        .stream(tmpMatrix)
                        .map(Arrays::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }


}
