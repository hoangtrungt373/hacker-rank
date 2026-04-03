package neetcode.removeElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.removeElement.RemoveElement;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class RemoveElementTest {

    @DataProvider
    public static Object[][] provideDataForRemoveElement() {
        return new Object[][] {
                // Examples (order does not matter)
                {new int[] {1, 1, 2, 3, 4}, 1, 3},
                {new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2, 5},

                // Edge / sanity cases
                {new int[] {}, 7, 0},
                {new int[] {5}, 5, 0},
                {new int[] {5}, 3, 1},
                {new int[] {2, 2, 2}, 2, 0},
                {new int[] {2, 2, 2}, 3, 3},
                {new int[] {3, 1, 3, 3, 2, 3, 4}, 3, 3}
        };
    }

    @Test
    @UseDataProvider("provideDataForRemoveElement")
    public void testRemoveElement(int[] nums, int val, int expectedK) {
        int[] original = nums.clone();

        RemoveElement solver = new RemoveElement();
        int actualK = solver.removeElementV2(nums, val);
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));

        Assert.assertEquals("Returned k is wrong", expectedK, actualK);
        Assert.assertTrue("k must be within array bounds", actualK >= 0 && actualK <= nums.length);

        // First k elements must not contain val
        for (int i = 0; i < actualK; i++) {
            Assert.assertNotEquals("Prefix contains val at index " + i, val, nums[i]);
        }

        // Prefix multiset must equal original elements excluding val (order-agnostic check)
        Map<Integer, Integer> expectedCounts = countsExcluding(original, val);
        Map<Integer, Integer> actualCounts = countsOfPrefix(nums, actualK);
        Assert.assertEquals("Prefix elements don't match expected multiset", expectedCounts, actualCounts);
    }

    private static Map<Integer, Integer> countsExcluding(int[] arr, int excluded) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x : arr) {
            if (x == excluded) {
                continue;
            }
            counts.put(x, counts.getOrDefault(x, 0) + 1);
        }
        return counts;
    }

    private static Map<Integer, Integer> countsOfPrefix(int[] arr, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int x = arr[i];
            counts.put(x, counts.getOrDefault(x, 0) + 1);
        }
        return counts;
    }
}
