package ttg.traning.week3.betweenTwoSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ttg
 */
public class BetweenTwoSets {

    public static List<Integer> process(List<Integer> listA, List<Integer> listB) {
        Collections.sort(listA);
        Collections.sort(listB);

        int maxA = listA.get(listA.size() - 1);
        int minB = listB.get(0);

        List<Integer> factors = new ArrayList<>();
        for (int i = maxA; i <= minB; i += maxA) {
            int finalI = i;
            if (minB % i == 0 && listA.stream().allMatch(a -> finalI % a == 0)) {
                factors.add(i);
            }
        }
        factors.removeIf(f -> listB.stream().anyMatch(b -> b % f != 0));

        return factors;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to compute the Least Common Multiple (LCM)
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Function to compute LCM of an array
    private static int lcmArray(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = lcm(result, arr.get(i));
        }
        return result;
    }

    // Function to compute GCD of an array
    private static int gcdArray(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = gcd(result, arr.get(i));
        }
        return result;
    }

    public static List<Integer> process1(List<Integer> a, List<Integer> b) {
        int lcmA = lcmArray(a);  // LCM of array a
        int gcdB = gcdArray(b);  // GCD of array b
        List<Integer> result = new ArrayList<>();

        // Check numbers that are multiples of LCM(a) and factors of GCD(b)
        for (int i = lcmA; i <= gcdB; i += lcmA) {
            if (gcdB % i == 0) {
                result.add(i);
            }
        }

        return result;
    }
}
