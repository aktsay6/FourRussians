package org.aktsay;

import org.aktsay.commands.ApplicationCommands;
import org.apache.log4j.Logger;
import picocli.CommandLine;

import java.util.Scanner;

public class Main {

    public static Logger logger = Logger.getLogger(Main.class);

    public static int[][] first;
    public static int[][] second;

    public static void main(String[] args) {
        new CommandLine(new ApplicationCommands()).execute(args);
        logger.info("Entering the application");

        inputMatrices();

        if (first.length == 1) {
            System.out.println(first[0][0] * second[0][0]);
            return;
        }

        FourRussiansAlgorithm algorithm = new FourRussiansAlgorithm();

        int[][] C = algorithm.multiply(first, second);

        System.out.println("Result:");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void inputMatrices() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter matrices dimension:");
        try {
            int dim = scanner.nextInt();

            first = new int[dim][dim];
            second = new int[dim][dim];

            System.out.println("Enter first matrix:");
            readMatrix(first, dim, scanner);
            System.out.println("Enter second matrix:");
            readMatrix(second, dim, scanner);
        } catch (Exception e) {
            System.out.println("Matrices should be NxN");
            System.exit(1);
        }
    }

    private static void readMatrix(int[][] arr, int dim, Scanner scanner) {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] != 1 && arr[i][j] != 0) {
                    System.err.println("Element should be 0 or 1");
                    System.exit(1);
                }
            }
        }
    }
}
