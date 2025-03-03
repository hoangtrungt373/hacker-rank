package ttg.traning.hackerrank.week4.rotateLeft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author ttg
 */
public class RotateLeft {

    public static List<Integer> process(int d, List<Integer> arr) {
        int n = arr.size();
        d = d % n; // Handle cases where d >= n
        List<Integer> rotated = new ArrayList<>(arr.subList(d, n));
        rotated.addAll(arr.subList(0, d));
        return rotated;
    }

    public static List<Integer> process1(int d, List<Integer> arr) {
        int n = arr.size();
        d = d % n; // Handle cases where d >= n

        // Reverse first d elements
        reverse(arr, 0, d - 1);

        // Reverse remaining elements
        reverse(arr, d, n - 1);

        // Reverse entire array
        reverse(arr, 0, n - 1);

        return arr;
    }

    private static void reverse(List<Integer> arr, int start, int end) {
        while (start < end) {
            Collections.swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static List<Integer> process2(int d, List<Integer> arr) {
        List<Integer> tempArr = new ArrayList<>();
        for (int j = 0; j < arr.size(); j++) {
            tempArr.add(arr.get((j + d) % arr.size()));
        }
        return tempArr;
    }
}
