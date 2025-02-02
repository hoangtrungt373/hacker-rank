package ttg.traning.week3.permutingTwoArrays;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author ttg
 */
public class PermutingTwoArrays {

    public static boolean process(int k, List<Integer> listA, List<Integer> listB) {

        Collections.sort(listA);
        listB.sort(Collections.reverseOrder());

        boolean satisfied = true;
        for (int i = 0; i < listA.size(); i++) {
            if (listA.get(i) + listB.get(i) < k) {
                satisfied = false;
                break;
            }
        }

        return satisfied;
    }

    public static boolean process1(int k, List<Integer> listA, List<Integer> listB) {

        Collections.sort(listA);
        listB.sort(Collections.reverseOrder());

        return IntStream.range(0, listB.size())
                .mapToObj(i -> listA.get(i) + listB.get(i) < k)
                .noneMatch(b -> b);
    }
}
