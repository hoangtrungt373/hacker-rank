package ttg.traning.week2.LoneLyInteger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ttg
 */
public class LonelyInteger {

    public static Integer process(List<Integer> integers) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int el : integers) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static Integer process1(List<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            int el = integers.get(i);
            if (i == integers.lastIndexOf(el)) {
                return el;
            }
        }
        return -1;
    }

    public static Integer process2(List<Integer> integers) {

        Set<Integer> set = new HashSet<>();

        for (int el : integers) {
            if(!set.contains(el)){
                set.add(el);
            }
            else set.remove(el);
        }
        return set.iterator().next();
    }

    // only work if arrays not exists element appears > 2 times
    public static Integer process3(List<Integer> integers) {
        return integers.stream().reduce((x,y) -> x^y).get();
    }
}
