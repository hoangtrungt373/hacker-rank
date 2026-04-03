package neetcode.concatenationOfArray;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.concatenationOfArray.ConcatenationOfArray;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class ConcatenationOfArrayTest {

    @DataProvider
    public static Object[][] provideDataForGetConcatenation() {
        return new Object[][] {
                // Examples from problem statement
                {new int[] {1, 4, 1, 2}, new int[] {1, 4, 1, 2, 1, 4, 1, 2}},
                {new int[] {22, 21, 20, 1}, new int[] {22, 21, 20, 1, 22, 21, 20, 1}},

                // Edge: single element
                {new int[] {7}, new int[] {7, 7}},

                // Edge: two elements
                {new int[] {1, 2}, new int[] {1, 2, 1, 2}}
        };
    }

    @Test
    @UseDataProvider("provideDataForGetConcatenation")
    public void testGetConcatenation(int[] nums, int[] expected) {
        int[] input = nums.clone();

        ConcatenationOfArray solver = new ConcatenationOfArray();
        int[] actual = solver.getConcatenation(input);

        Assert.assertArrayEquals(expected, actual);
    }
}
