package ttg.traning.hackerrank.week2.flippingMatrix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ttg
 */
public class FlippingMatrix {

    public static int process(List<List<Integer>> matrix) {
        int maxSum = 0;
        int subMatrixSize = matrix.size() / 2;

//        Initial Matrix:
//        [112, 42, 83, 119]
//        [56, 125, 56, 49]
//        [15, 78, 101, 43]
//        [62, 98, 114, 108]

//        Calculating Maximum for nxn Submatrix:
//        For position (0, 0): Maximum of 112, 119, 62, 108 → 119
//        For position (0, 1): Maximum of 42, 83, 98, 114 → 114
//        For position (1, 0): Maximum of 56, 49, 15, 62 → 56
//        For position (1, 1): Maximum of 125, 56, 78, 101 → 125

//        Sum: 119 + 114 + 56 + 125 = 414.

        int size = matrix.size(); // Assuming a square matrix
        for (int i = 0; i < subMatrixSize; i++) {
            for (int j = 0; j < subMatrixSize; j++) {
                // Calculate the four possible values for the current position
                int topLeft = matrix.get(i).get(j);
                int topRight = matrix.get(i).get(size - 1 - j);
                int bottomLeft = matrix.get(size - 1 - i).get(j);
                int bottomRight = matrix.get(size - 1 - i).get(size - 1 - j);

                // Choose the maximum value
                maxSum += Math.max(Math.max(topLeft, topRight), Math.max(bottomLeft, bottomRight));
            }
        }
        return maxSum;
    }

    private static List<List<Integer>> toModifiableMatrix(List<List<Integer>> unmodifiableMatrix) {
        List<List<Integer>> modifiableMatrix = new ArrayList<>();
        for (List<Integer> row : unmodifiableMatrix) {
            modifiableMatrix.add(new ArrayList<>(row));
        }
        return modifiableMatrix;
    }

    private static void reverseRow(List<List<Integer>> matrix, int rowReverse) {
        List<Integer> row = matrix.get(rowReverse);
        Collections.reverse(row);
    }

    private static void reverseCol(List<List<Integer>> matrix, int colReverse) {
        int top = 0;
        int bottom = matrix.size() - 1;

        while (top < bottom) {
            // Swap elements in the column
            int temp = matrix.get(top).get(colReverse);
            matrix.get(top).set(colReverse, matrix.get(bottom).get(colReverse));
            matrix.get(bottom).set(colReverse, temp);

            top++;
            bottom--;
        }
    }
    private static void reverseCol1(List<List<Integer>> matrix, int colReverse) {
        List<Integer> colItems = matrix.stream().map(row -> row.get(colReverse)).collect(Collectors.toList());
        Collections.reverse(colItems);
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).set(colReverse, colItems.get(i));
        }
    }

    private static List<List<Integer>> extractUpperLeftQuadrantMatrix(List<List<Integer>> matrix, int subMatrixSize) {
        List<List<Integer>> subMatrix = new ArrayList<>();
        for (int i = 0; i < subMatrixSize; i++) {
            subMatrix.add(new ArrayList<>(matrix.get(i).subList(0, subMatrixSize)));
        }
        return subMatrix;
    }

    private static int sumElementInMatrix(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(Collection::stream).reduce(0, Integer::sum);
    }
}
