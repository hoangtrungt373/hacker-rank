package neetcode.replaceElements;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.replaceElements.ReplaceElement;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class ReplaceElementTest {

    @DataProvider
    public static Object[][] provideDataForReplaceElements() {
        return new Object[][] {
                // Examples from problem statement
                {new int[] {2, 4, 5, 3, 1, 2}, new int[] {5, 5, 3, 2, 2, -1}},
                {new int[] {3, 3}, new int[] {3, -1}},

                // Single element: last becomes -1
                {new int[] {7}, new int[] {-1}},

                // Two elements, distinct
                {new int[] {1, 2}, new int[] {2, -1}},
                {new int[] {2, 1}, new int[] {1, -1}}
        };
    }

    @Test
    @UseDataProvider("provideDataForReplaceElements")
    public void testReplaceElements(int[] input, int[] expected) {
        int[] nums = input.clone();

        ReplaceElement solver = new ReplaceElement();
        int[] actual = solver.replaceElements(nums);
        System.out.println(Arrays.toString(Arrays.stream(actual).toArray()));
        Assert.assertArrayEquals(expected, actual);
    }
}
