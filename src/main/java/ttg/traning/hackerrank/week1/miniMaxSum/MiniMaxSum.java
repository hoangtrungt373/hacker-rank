package ttg.traning.hackerrank.week1.miniMaxSum;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ttg
 */
public class MiniMaxSum {

    public static List<Long> process(List<Integer> arr) {
        long max =  Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        long sum = 0;

        for(long e : arr){
            max = Math.max(e,max);
            min = Math.min(e,min);
            sum += e;
        }
        return Arrays.asList((sum - max), (sum - min));
    }
}
