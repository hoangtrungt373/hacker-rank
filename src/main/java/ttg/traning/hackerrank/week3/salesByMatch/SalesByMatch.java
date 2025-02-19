package ttg.traning.hackerrank.week3.salesByMatch;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ttg
 */
public class SalesByMatch {

    public static int process(List<Integer> ar) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int value : ar) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        return countMap.values().stream().map(i -> i / 2).reduce(0, Integer::sum);
    }

    public static int process1(List<Integer> ar) {
        HashSet<Integer> m = new HashSet<>();
        for (Integer integer : ar) {
            if (m.contains(integer)) {
                m.remove(integer);
            } else {
                m.add(integer);
            }
        }

        return (ar.size() - m.size()) / 2;

    }

    public static int process2(List<Integer> ar) {
        int count = 0;
        int n = ar.size();
        Collections.sort(ar);
        for (int i = 1; i < n; i++) {
            if (ar.get(i - 1) == ar.get(i)) {
                ar.remove(i);
                ar.remove(i - 1);
                i--;
                n -= 2;
                count++;
            }
        }
        return count;
    }

    public static int process3(List<Integer> ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : ar) {

            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            if (map.get(i) % 2 == 0)
                count++;
        }

        return count;

    }
}