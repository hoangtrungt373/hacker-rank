package ttg.traning.week3.subarrayDivision2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ttg
 */
public class SubarrayDivision2 {

    public static int process(List<Integer> s, int d, int m) {
        if (s.size() == 1) {
            return s.get(0) == d ? 1 : 0;
        }
        int count = 0;
        for (int i = 0; i < (s.size() - m) + 1; i++) {
            int countSubArr = s.subList(i, i + m).stream().mapToInt(x -> x).sum();
            if (countSubArr == d) {
                count++;
            }
        }
        return count;
    }

    public static int process1(List<Integer> s, int d, int m) {
        int currSize = 0;
        int numWays = 0;
        if (s.size() < m) return 0;

        // get sum of first segement (first m elements)
        for (int i = 0; i < m; i++) {
            currSize += s.get(i);
        }
        // check sum == d
        if (currSize == d) {
            numWays++;
        }

        // sliding window, subtract prev element and add next element to get sum of the next segment (size m)
        // starts at 1 because you already calculated first segement sum
        // ends on the last segment of size m
        for (int j = 1; j < s.size() - m + 1; j++) {
            currSize -= s.get(j - 1);
            currSize += s.get(j + m - 1);

            if (currSize == d) {
                numWays++;
            }
        }

        return numWays;
    }

    List<Integer> list_1 = Arrays.asList(2, 2, 1, 3, 2);
    int d_1 = 4;
    int m_1 = 2;
    int output_1 = 2; // [2, 2], [1, 3]

}
