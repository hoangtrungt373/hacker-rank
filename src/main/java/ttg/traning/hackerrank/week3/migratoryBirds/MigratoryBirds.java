package ttg.traning.hackerrank.week3.migratoryBirds;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author ttg
 */
public class MigratoryBirds {

    public static int process(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int mostFrequently = 0;
        for(Integer val : arr) {
            int frequency = map.getOrDefault(val, 0);
            map.put(val, frequency + 1);
            mostFrequently = Math.max(mostFrequently, frequency + 1);
        }
        int finalMostFrequently = mostFrequently;
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == finalMostFrequently)
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
    }

    public static int process1(List<Integer> arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        int minId = Integer.MAX_VALUE;

        // Count occurrences and track max frequency
        for (int id : arr) {
            int frequency = frequencyMap.getOrDefault(id, 0) + 1;
            frequencyMap.put(id, frequency);

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                minId = id; // Reset to current ID
            } else if (frequency == maxFrequency) {
                minId = Math.min(minId, id); // Update to smaller ID
            }
        }

        return minId;
    }

    public static int process2(List<Integer> arr) {
        var groups = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return groups.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(0);
    }
}
