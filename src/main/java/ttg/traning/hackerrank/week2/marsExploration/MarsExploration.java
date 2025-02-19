package ttg.traning.hackerrank.week2.marsExploration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author ttg
 */
public class MarsExploration {

    public static int process(String str) {
        int amountOfChangedLetter = 0;
        final String sosMessage = "SOS";
        for (int i = 0; i < str.length(); i += sosMessage.length()) {
            if (str.charAt(i) != 'S') {
                amountOfChangedLetter++;
            }
            if (str.charAt(i + 1) != 'O') {
                amountOfChangedLetter++;
            }
            if (str.charAt(i + 2) != 'S') {
                amountOfChangedLetter++;
            }
        }
        return amountOfChangedLetter;
    }

    public static int process1(String str) {
        int amountOfChangedLetter = 0;
        final String sosMessage = "SOS";

        for (int i = 0; i < str.length(); i++) {
            // Calculate the corresponding index in the SOS message
            char expectedChar = sosMessage.charAt(i % sosMessage.length());
            // Compare the character in the string with the expected character
            if (str.charAt(i) != expectedChar) {
                amountOfChangedLetter++;
            }
        }

        return amountOfChangedLetter;
    }

    public static int process2(String str) {
        char[] sos = "SOS".toCharArray();
        return (int) IntStream.range(0, str.length())
                .filter(i -> str.charAt(i) != sos[i % 3])
                .count();
    }
}
