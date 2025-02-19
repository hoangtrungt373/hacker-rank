package ttg.traning.hackerrank.week3.drawingBook;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author ttg
 */
public class DrawingBook {

    public static int process(int n, int p) {
        boolean isOdd = n % 2 != 0;
        BigDecimal middle = BigDecimal.valueOf(n).divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP);
        if (BigDecimal.valueOf(p).compareTo(middle) <= 0) {
            return BigDecimal.valueOf(p).divide(BigDecimal.valueOf(2), RoundingMode.DOWN).intValue();
        } else {
            if (isOdd) {
                return BigDecimal.valueOf(n - p).divide(BigDecimal.valueOf(2), RoundingMode.DOWN).intValue();
            } else {
                return BigDecimal.valueOf(n - p).divide(BigDecimal.valueOf(2), RoundingMode.UP).intValue();
            }
        }
    }

    public static int process1(int n, int p) {
        int fromFront = p / 2;
        int fromBack = (n / 2) - (p / 2);
        return Math.min(fromFront, fromBack);
    }

    public static int process2(int n, int p) {
        if (p <= n / 2) { //minimum page turns is always p/2.
            return p / 2;
        } else {
            return (n / 2) - (p / 2);
        }
    }

    public static int process3(int n, int p) {
        return Integer.min(p / 2, (n - p + (p % 2)) / 2);
    }
}
