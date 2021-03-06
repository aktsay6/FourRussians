import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {

    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        // Need to implement read from file

        // LogManager.getRootLogger().setLevel(Level.DEBUG);
        logger.info("Entering the application");
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
