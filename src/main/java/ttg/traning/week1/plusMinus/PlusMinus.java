package ttg.traning.week1.plusMinus;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ttg
 */
public class PlusMinus {

    public static List<Double> process(List<Integer> arr) {

        final int arrSize = arr.size();
        final double zeroSixDecimals = 0.000000;
        double positiveRatio = 0;
        double negativeRatio = 0;
        double zeroRatio = 0;

        for (Integer x : arr) {
            if (x > 0) {
                positiveRatio++;
            } else if (x < 0) {
                negativeRatio++;
            } else {
                zeroRatio++;
            }
        }

        return Arrays.asList((positiveRatio + zeroSixDecimals) / arrSize, (negativeRatio + zeroSixDecimals) / arrSize, (zeroRatio + zeroSixDecimals) / arrSize);
    }

    public static List<Double> process1(List<Integer> arr) {
        int totalCount = arr.size();

        // Count positive, negative, and zero numbers
        double positiveCount = 0;
        double negativeCount = 0;
        double zeroCount = 0;

        for (int num : arr) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        // Calculate ratios
        double positiveRatio = positiveCount / totalCount;
        double negativeRatio = negativeCount / totalCount;
        double zeroRatio = zeroCount / totalCount;

        // Return ratios
        return Arrays.asList(positiveRatio, negativeRatio, zeroRatio);
    }

    public static List<Double> process2(List<Integer> arr) {
        int totalCount = arr.size();

        // Calculate counts using streams
        long positiveCount = arr.stream().filter(num -> num > 0).count();
        long negativeCount = arr.stream().filter(num -> num < 0).count();
        long zeroCount = totalCount - positiveCount - negativeCount; // Remaining are zeros

        // Calculate and return ratios
        return Arrays.asList(
                positiveCount / (double) totalCount,
                negativeCount / (double) totalCount,
                zeroCount / (double) totalCount
        );
    }
}
