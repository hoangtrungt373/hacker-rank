package ttg.traning.hackerrank.week2.countingSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author ttg
 */
public class CountingSort {

    public static List<Integer> process(List<Integer> arr) {
        int[] count = new int[arr.size()];
        for (int value : arr) {
            count[value]++;
        }
        return Arrays.stream(count).boxed().collect(Collectors.toList());
    }

    public static List<Integer> process1(List<Integer> arr) {
        return arr.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting())).values().stream().map(Long::intValue).collect(Collectors.toList());
    }

    public static List<Integer> process2(List<Integer> arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int value : arr) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        return new ArrayList<>(countMap.values());
    }
}
