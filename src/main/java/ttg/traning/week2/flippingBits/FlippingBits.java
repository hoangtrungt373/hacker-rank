package ttg.traning.week2.flippingBits;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ttg
 */
public class FlippingBits {

    public static long process(long number) {
        String unsigned32BitStr = String.format("%32s", Long.toBinaryString(number)).replace(' ', '0');
        char[] flippingUnsigned32BitChars = new char[unsigned32BitStr.length()];
        for (int i = 0; i < unsigned32BitStr.length(); i++) {
            char c = unsigned32BitStr.charAt(i);
            flippingUnsigned32BitChars[i] = c == '0' ? '1' : '0';
        }

        return Long.parseLong(String.valueOf(flippingUnsigned32BitChars), 2);
    }

    public static long process1(long number) {
        // The ^ (XOR) operator flips the bits of number wherever the corresponding bit in the mask (0xFFFFFFFFL) is 1
        return number ^ 0xFFFFFFFFL;
    }
}
