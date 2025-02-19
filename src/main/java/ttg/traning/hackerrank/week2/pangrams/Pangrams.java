package ttg.traning.hackerrank.week2.pangrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author ttg
 */
public class Pangrams {
    
    public static boolean process(String str) {
        List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        str = str.replace(" ", "").toLowerCase();

        String finalStr = str;
        return !alphabet.stream().anyMatch(aChar -> !finalStr.contains(aChar));
    }

    public static boolean process1(String str) {
        // Create a Set of all lowercase alphabet characters
        Set<Character> alphabet = IntStream.rangeClosed('a', 'z')
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        // Create a Set of all characters in the input string (ignoring spaces and case)
        Set<Character> inputChars = str.toLowerCase()
                .replace(" ", "")
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        // Check if the input contains all alphabet characters
        return inputChars.containsAll(alphabet);
    }

    public static boolean process2(String str) {
        return IntStream.rangeClosed('a', 'z')
                .allMatch(c -> str.toLowerCase().indexOf(c) >= 0);
    }
}
