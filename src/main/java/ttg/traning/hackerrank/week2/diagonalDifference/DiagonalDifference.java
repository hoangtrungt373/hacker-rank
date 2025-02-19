package ttg.traning.hackerrank.week2.diagonalDifference;

import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author ttg
 */
public class DiagonalDifference {

    public static int process(List<List<Integer>> matrix) {
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;

        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            leftDiagonalSum += row.get(i);
            rightDiagonalSum += row.get(row.size() - i - 1);
        }
        return Math.abs(leftDiagonalSum - rightDiagonalSum);
    }

    public static int process1(int[][] matrix) {
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            leftDiagonalSum += matrix[i][i];
            rightDiagonalSum += matrix[i][matrix.length - i - 1];
        }

        return Math.abs(leftDiagonalSum - rightDiagonalSum);
    }

    public static int process2(int[][] matrix) {
        int n = matrix.length;

        int leftDiagonalSum = IntStream.range(0, n)
                .parallel()
                .map(i -> matrix[i][i])
                .sum();

        int rightDiagonalSum = IntStream.range(0, n)
                .parallel()
                .map(i -> matrix[i][n - i - 1])
                .sum();

        return Math.abs(leftDiagonalSum - rightDiagonalSum);
    }
}
