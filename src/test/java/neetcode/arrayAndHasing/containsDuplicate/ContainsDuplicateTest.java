package neetcode.arrayAndHasing.containsDuplicate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.arrayAndHasing.containsDuplicate.ContainsDuplicate;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class ContainsDuplicateTest {

    @DataProvider
    public static Object[][] provideDataForHasDuplicate() {
        return new Object[][] {
                // Examples from problem statement
                {new int[] {1, 2, 3, 3}, true},
                {new int[] {1, 2, 3, 4}, false},

                // More cases
                {new int[] {1}, false},
                {new int[] {1, 1}, true},
                {new int[] {-1, -1}, true},
                {new int[] {0, 1, 0}, true},
                {new int[] {1000000, 999999, 1000000}, true}
        };
    }

    @Test
    @UseDataProvider("provideDataForHasDuplicate")
    public void testHasDuplicate(int[] nums, boolean expected) {
        int[] input = nums.clone();

        ContainsDuplicate solver = new ContainsDuplicate();
        boolean actual = solver.hasDuplicate(input);

        Assert.assertEquals(expected, actual);
    }
}
