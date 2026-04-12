package neetcode.sortColor;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.sortColor.SortColor;

/**
 * Tests for {@link SortColor#sortColors(int[])} — Dutch national flag / sort colors in-place.
 * <p>
 * Expected order: all {@code 0}s, then all {@code 1}s, then all {@code 2}s.
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class SortColorTest {

    @DataProvider
    public static Object[][] provideDataForSortColors() {
        return new Object[][] {
                // Examples from problem statement
                {new int[] {1, 0, 1, 2}, new int[] {0, 1, 1, 2}},
                {new int[] {2, 1, 0}, new int[] {0, 1, 2}},

                // Single element
                {new int[] {0}, new int[] {0}},
                {new int[] {1}, new int[] {1}},
                {new int[] {2}, new int[] {2}},

                // Already sorted
                {new int[] {0, 0, 1, 1, 2, 2}, new int[] {0, 0, 1, 1, 2, 2}},

                // Reverse-heavy / mixed
                {new int[] {2, 2, 1, 0, 1, 0}, new int[] {0, 0, 1, 1, 2, 2}},
                {new int[] {2, 0, 2, 1, 1, 0}, new int[] {0, 0, 1, 1, 2, 2}},

                // All one color
                {new int[] {0, 0, 0}, new int[] {0, 0, 0}},
                {new int[] {1, 1, 1}, new int[] {1, 1, 1}},
                {new int[] {2, 2, 2}, new int[] {2, 2, 2}},

                // Two colors only
                {new int[] {1, 0, 0, 1}, new int[] {0, 0, 1, 1}},
                {new int[] {2, 0, 2, 0}, new int[] {0, 0, 2, 2}},
        };
    }

    @Test
    @UseDataProvider("provideDataForSortColors")
    public void testSortColors(int[] nums, int[] expected) {
        int[] work = nums.clone();
        int c0 = count(work, 0);
        int c1 = count(work, 1);
        int c2 = count(work, 2);

        new SortColor().sortColors(work);
        System.out.println(Arrays.toString(Arrays.stream(work).toArray()));
        Assert.assertArrayEquals(
                "nums must equal [0..0, 1..1, 2..2] for input " + Arrays.toString(nums),
                expected,
                work);

        Assert.assertEquals("count of 0", c0, count(work, 0));
        Assert.assertEquals("count of 1", c1, count(work, 1));
        Assert.assertEquals("count of 2", c2, count(work, 2));

        int i = 0;
        while (i < work.length && work[i] == 0) {
            i++;
        }
        while (i < work.length && work[i] == 1) {
            i++;
        }
        while (i < work.length && work[i] == 2) {
            i++;
        }
        Assert.assertEquals("Array should be 0* 1* 2* from left to right", work.length, i);
    }

    private static int count(int[] nums, int v) {
        int n = 0;
        for (int x : nums) {
            if (x == v) {
                n++;
            }
        }
        return n;
    }
}
