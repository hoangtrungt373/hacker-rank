package neetcode.arrayAndHasing.longestConsecutiveSequence;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.arrayAndHasing.longestConsecutiveSequence.LongestConsecutiveSequence;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class LongestConsecutiveSequenceTest {

    @DataProvider
    public static Object[][] provideDataForLongestConsecutive() {
        return new Object[][] {
                // Examples
                {new int[] {2, 20, 4, 10, 3, 4, 5}, 4},
                {new int[] {0, 3, 2, 5, 4, 6, 1, 1}, 7},

                // Edge cases
                {new int[] {}, 0},
                {new int[] {7}, 1},
                {new int[] {1, 2}, 2},
                {new int[] {2, 1}, 2},

                // Duplicates
                {new int[] {1, 2, 2, 3}, 3},
                {new int[] {5, 5, 5}, 1},

                // Mixed / gaps
                {new int[] {100, 4, 200, 1, 3, 2}, 4},
                {new int[] {10, 30, 20}, 1},
                {new int[] {-1, -2, -3, 10, 11}, 3},
                {new int[] {-1, 0, 1, 2, -2}, 5},

                // Boundary values in constraints
                {new int[] {-1000000000, 1000000000}, 1},
                {new int[] {-1000000000, -999999999, -999999998}, 3},
        };
    }

    @Test
    @UseDataProvider("provideDataForLongestConsecutive")
    public void testLongestConsecutive(int[] nums, int expected) {
        int[] input = nums.clone();

        LongestConsecutiveSequence solver = new LongestConsecutiveSequence();
        int actual = solver.longestConsecutive(input);

        Assert.assertEquals(expected, actual);
    }
}
