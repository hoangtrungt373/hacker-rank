package ttg.traning.week1.sparseArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ttg
 */
public class SparseArrays {

    public static List<Integer> process(List<String> strings, List<String> queries ) {

        List<Integer> countQueInStrs = new ArrayList<>();

        for (int i = 0; i < queries.size(); i++) {
            int finalI = i;
            int countQueInStr = (int) strings.stream().filter(s -> s.equals(queries.get(finalI))).count();
            countQueInStrs.add(countQueInStr);
        }

        return countQueInStrs;
    }

    public static List<Integer> process1(List<String> strings, List<String> queries ) {

        Map<String, Integer> map = new HashMap<>();

        List<Integer> freq = new ArrayList<>();
        for (String s : strings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
        for (String t : queries) {
            freq.add(map.getOrDefault(t, 0));
        }
        return freq;
    }


}
