public class Util {

    public static int[][] createMatrix(int n, int m) {
        return new int[n][m];
    }

    public static int intPow(int number, int power) {
        return (int)Math.pow(number, power);
    }

    public static int[] getRowOrColumn(int[][] arr, int index, boolean rowWise) {
        int[] ints = new int[arr.length];
        if (index >= arr.length) {
            return ints;
        }
        for (int i = 0; i < arr.length; i++) {
            if (rowWise)
                ints[i] = arr[index][i];
            else
                ints[i] = arr[i][index];
        }
        return ints;
    }

    public static int log2(int N)
    {
        return (int)(Math.log(N) / Math.log(2));
    }

    public static int[] rowFromBottom(int[][] arr, int amount) {
        return arr[arr.length - amount - 1];
    }

    public static int[] sumRows(int[] first, int[] second) {
        int[] result = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            if (first[i] + second[i] > 0)
                result[i] = 1;
            else
                result[i] = 0;
        }
        return result;
    }

    public static int getDecimalNumber(int[] row) {
        int res = 0;
        for (int i = row.length - 1; i >= 0; i--) {
            if (row[i] != 0) {
                res += Math.pow(2, row.length - i - 1);
            }
        }
        return res;
    }

    public static int[][] matrixSum(int[][] first, int[][] second) {
        int n = first.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = first[i][j] + second[i][j];

                if (result[i][j] > 0) result[i][j] = 1;
            }
        }

        return result;
    }
}
