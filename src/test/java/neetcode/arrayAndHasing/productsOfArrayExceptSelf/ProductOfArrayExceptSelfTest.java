package neetcode.arrayAndHasing.productsOfArrayExceptSelf;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.arrayAndHasing.productsOfArrayExceptSelf.ProductOfArrayExceptSelf;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class ProductOfArrayExceptSelfTest {

    @DataProvider
    public static Object[][] provideDataForProductExceptSelf() {
        return new Object[][] {
                // Examples
                {new int[] {1, 2, 4, 6}, new int[] {48, 24, 12, 8}},
                {new int[] {-1, 0, 1, 2, 3}, new int[] {0, -6, 0, 0, 0}},

                // Edge / sanity cases
                {new int[] {1, 2}, new int[] {2, 1}},
                {new int[] {0, 2}, new int[] {2, 0}},
                {new int[] {0, 0, 5}, new int[] {0, 0, 0}},
                {new int[] {2, 3, 4, 5}, new int[] {60, 40, 30, 24}},
                {new int[] {-1, -2, -3, -4}, new int[] {-24, -12, -8, -6}},
                {new int[] {1, 0, 0, 4}, new int[] {0, 0, 0, 0}},
                {new int[] {-2, 1, -3, 4}, new int[] {-12, 24, -8, 6}},
        };
    }

    @Test
    @UseDataProvider("provideDataForProductExceptSelf")
    public void testProductExceptSelf(int[] nums, int[] expected) {
        int[] input = nums.clone();

        ProductOfArrayExceptSelf solver = new ProductOfArrayExceptSelf();
        int[] actual = solver.productExceptSelf(input);

        Assert.assertArrayEquals(expected, actual);
    }
}
