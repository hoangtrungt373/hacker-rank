package week1;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week1.divisibleSumPairs.DivisibleSumPairs;
import ttg.traning.week2.loneLyInteger.LonelyInteger;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class DivisibleSumPairsTest {

    @DataProvider
    public static Object[][] provideDataForTestDivisibleSumPairs() {

        List<Integer> arr = Arrays.asList(1, 3, 2, 6, 1, 2 );
        int k = 3;
        int count = 5;

        return new Object[][] {
                {arr, k, count},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestDivisibleSumPairs")
    public void testDivisibleSumPairs(List<Integer> arr, int k, int expectedOutput) {
        int actualOutput = DivisibleSumPairs.process(arr, k);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
