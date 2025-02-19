package hackerrank.week3;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week3.permutingTwoArrays.PermutingTwoArrays;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class PermutingTwoArraysTest {

    @DataProvider
    public static Object[][] provideDataForTestPermutingTwoArrays() {

        List<Integer> listA_1 = Arrays.asList(2, 1, 3);
        List<Integer> listB_1 = Arrays.asList(7, 8, 9);
        int k_1 = 10;

        List<Integer> listA_2 = Arrays.asList(1, 2, 2, 1);
        List<Integer> listB_2 = Arrays.asList(3, 3, 3, 4);
        int k_2 = 5;

        List<Integer> listA_3 = Arrays.asList(0, 1);
        List<Integer> listB_3 = Arrays.asList(0, 2);
        int k_3 = 1;

        List<Integer> listA_4 = Arrays.asList(4, 4, 3, 2, 1, 4, 4, 3, 2, 4);
        List<Integer> listB_4 = Arrays.asList(2, 3, 0, 1, 1, 3, 1, 0, 0, 2);
        int k_4 = 4;

        return new Object[][] {
                {k_1, listA_1, listB_1, true},
                {k_2, listA_2, listB_2, false},
                {k_3, listA_3, listB_3, true},
                {k_4, listA_4, listB_4, true},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestPermutingTwoArrays")
    public void testPermutingTwoArrays(int k, List<Integer> listA, List<Integer> listB, boolean expectedOutput) {
        boolean actualOutput = PermutingTwoArrays.process(k, listA, listB);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
