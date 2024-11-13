package ttg.traning.week1.divisibleSumPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ttg
 */
public class DivisibleSumPairs {
    public static void main(String[] args) {

        List<Integer> ar = Arrays.asList(1, 3, 2, 6, 1, 2 );
        int k = 3;
        int count = divisibleSumPairs2(ar.size(),k, ar);
        System.out.println(count);
    }

    public static int divisibleSumPairs1(int n, int k, List<Integer> ar) {
        int countDivisible = 0;
        for (int i = 0; i < ar.size(); i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    countDivisible++;
                }
            }
        }
        return countDivisible;
    }

    public static int divisibleSumPairs2(int n, int k, List<Integer> ar) {
        Map<Integer, Integer> map = new HashMap<>();
        int noOfPair = 0;

        for (int i = 0; i < ar.size(); i++) {
            System.out.printf("%nIndex: %d%n", i);
            int num = ar.get(i);
            int remainder = num % k;
            int diff = k - remainder;
            System.out.printf("num = %d, remainder = %d, diff = %d%n", num, remainder, diff);

            if (diff == k) {
                System.out.printf("diff == k -> diff = 0%n");
                diff = 0;
            }

            if (map.containsKey(diff)) {
                noOfPair += map.get(diff);
                System.out.printf("NoOfPair updated: " + noOfPair + "%n");
            }

            if (map.containsKey(remainder)) {
                System.out.printf("Remainder in map updated%n");
                int count = map.get(remainder);
                map.put(remainder, count + 1);
            } else {
                System.out.printf("New remainder in map%n");
                map.put(remainder, 1);
            }
            System.out.printf("Map updated: " + map + "%n");
        }
        return noOfPair;
    }
}
