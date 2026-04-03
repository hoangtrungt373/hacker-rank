package neetcode.maxConsecutivesOnes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.maxConsecutivesOnes.MaxConsecutiveOnes;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class MaxConsecutiveOnesTest {

    @DataProvider
    public static Object[][] provideDataForFindMaxConsecutiveOnes() {
        int[] nums_1 = new int[] {1, 1, 0, 1, 1, 1};
        int output_1 = 3;

        int[] nums_2 = new int[] {1, 0, 1, 1, 0, 1};
        int output_2 = 2;

        int[] nums_3 = new int[] {0, 0, 0, 0};
        int output_3 = 0;

        int[] nums_4 = new int[] {1, 1, 1, 1, 1};
        int output_4 = 5;

        int[] nums_5 = new int[] {1};
        int output_5 = 1;

        int[] nums_6 = new int[] {0};
        int output_6 = 0;

        int[] nums_7 = new int[100000];
        for (int i = 0; i < nums_7.length; i++) {
            nums_7[i] = (i >= 20000 && i < 90000) ? 1 : 0;
        }
        int output_7 = 70000;

        return new Object[][] {
                {nums_1, output_1},
                {nums_2, output_2},
                {nums_3, output_3},
                {nums_4, output_4},
                {nums_5, output_5},
                {nums_6, output_6},
                {nums_7, output_7}
        };
    }

    @Test
    @UseDataProvider("provideDataForFindMaxConsecutiveOnes")
    public void testFindMaxConsecutiveOnes(int[] nums, int expectedOutput) {
        MaxConsecutiveOnes solver = new MaxConsecutiveOnes();
        int actualOutput = solver.findMaxConsecutiveOnes(nums);

        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
