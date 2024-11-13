package ttg.traning.week2.GradingStudents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ttg
 */
public class GradingStudents {

    public static List<Integer> process(List<Integer> grades, Integer failingGrade, Integer maxDiffAllow) {

        int minAllowGradeToRound = failingGrade - maxDiffAllow;

        List<Integer> roundingGrades = new ArrayList<>();
        for (int el : grades) {
            if (el > minAllowGradeToRound) {
                int remainder = el % 5;
                if (remainder > 0 && remainder >= maxDiffAllow) {
                    el = el + (5 - remainder);
                }
            }
            roundingGrades.add(el);
        }
        return roundingGrades;
    }
}
