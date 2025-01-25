package week1;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week1.breakingTheRecords.BreakingTheRecords;
import ttg.traning.week1.divisibleSumPairs.DivisibleSumPairs;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class BreakingTheRecordsTest {

    @DataProvider
    public static Object[][] provideDataForTestBreakingTheRecords() {

        List<Integer> input1 = Arrays.asList(12, 24, 10, 24);
        List<Integer> output1 = Arrays.asList(1, 1);

        List<Integer> input2 = Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1);
        List<Integer> output2 = Arrays.asList(2, 4);
        return new Object[][] {
                {input1, output1},
                {input2, output2},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestBreakingTheRecords")
    public void testBreakingTheRecords(List<Integer> input, List<Integer> expectedOutput) {
        List<Integer> actualOutput = BreakingTheRecords.process(input);
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedOutput, actualOutput));
    }
}
