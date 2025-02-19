package ttg.traning.hackerrank.week3.maximumPerimeterTriangle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ttg
 */
public class MaximumPerimeterTriangle {

    public static List<Integer> process(List<Integer> sticks) {
        Collections.sort(sticks);

        for (int i = sticks.size() - 3; i >= 0; i--) {
            int a = sticks.get(i);
            int b = sticks.get(i + 1);
            int c = sticks.get(i + 2);
            if (a + b > c) {
                return Arrays.asList(a, b, c);
            }
        }
        return Collections.singletonList(-1);
    }
}
