package neetcode.topKFrequentElements;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.topKFrequentElements.TopKFrequentElements;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class TopKFrequentElementsTest {

    @DataProvider
    public static Object[][] provideDataForTopKFrequent() {
        return new Object[][] {
                // Examples from problem statement
                {new int[] {1, 2, 2, 3, 3, 3}, 2, new int[] {2, 3}},
                {new int[] {7, 7}, 1, new int[] {7}},

                // More cases
                {new int[] {1}, 1, new int[] {1}},
                {new int[] {1, 2, 3}, 3, new int[] {1, 2, 3}},
                {new int[] {1, 1, 1, 2, 2, 3}, 2, new int[] {1, 2}},
                {new int[] {-1, -1, 2, 2, 2, 3}, 2, new int[] {2, -1}},
                {new int[] {4, 1, -1, 2, -1, 2, 3}, 2, new int[] {-1, 2}},
                {new int[] {0, 0, 0, 1, 1, 2}, 2, new int[] {0, 1}},
        };
    }

    @Test
    @UseDataProvider("provideDataForTopKFrequent")
    public void testTopKFrequent(int[] nums, int k, int[] expected) {
        int[] input = nums.clone();

        TopKFrequentElements solver = new TopKFrequentElements();
        int[] actual = solver.topKFrequent(input, k);

        assertSameMultiset(expected, actual);
    }

    /**
     * Problem allows any order; compare as multisets.
     */
    private static void assertSameMultiset(int[] expected, int[] actual) {
        Assert.assertNotNull(actual);
        Assert.assertEquals("result length must equal k", expected.length, actual.length);

        int[] e = expected.clone();
        int[] a = actual.clone();
        Arrays.sort(e);
        Arrays.sort(a);
        Assert.assertArrayEquals(e, a);
    }
}
