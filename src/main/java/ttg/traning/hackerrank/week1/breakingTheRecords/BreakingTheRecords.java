package ttg.traning.hackerrank.week1.breakingTheRecords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ttg
 */
public class BreakingTheRecords {

    public static List<Integer> process(List<Integer> scores) {

        int countBreakingRecordMost = 0;
        int countBreakingRecordLeast = 0;

        int maxScore = scores.get(0);
        int minScore = scores.get(0);

        for (int score : scores.stream().skip(1).toList()) {
            if (score > maxScore) {
                maxScore = score;
                countBreakingRecordMost++;
            } else if (score < minScore) {
                minScore = score;
                countBreakingRecordLeast++;
            }
        }

        return Arrays.asList(countBreakingRecordMost, countBreakingRecordLeast);
    }
}
