package neetcode.arrayAndHasing.twoSum;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.arrayAndHasing.twoSum.TwoSum;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class TwoSumTest {

    @DataProvider
    public static Object[][] provideDataForTwoSum() {
        return new Object[][] {
                // Examples from problem statement
                {new int[] {3, 4, 5, 6}, 7, new int[] {0, 1}},
                {new int[] {4, 5, 6}, 10, new int[] {0, 2}},
                {new int[] {5, 5}, 10, new int[] {0, 1}},

                // More cases
                {new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}},
                {new int[] {-1, 0, 1}, 0, new int[] {0, 2}},
                {new int[] {0, 4, 3, 0}, 0, new int[] {0, 3}},
        };
    }

    @Test
    @UseDataProvider("provideDataForTwoSum")
    public void testTwoSum(int[] nums, int target, int[] expected) {
        int[] input = nums.clone();

        TwoSum solver = new TwoSum();
        int[] actual = solver.twoSum(input, target);
        System.out.println(Arrays.toString(actual));
        Assert.assertArrayEquals(expected, actual);
    }
}
