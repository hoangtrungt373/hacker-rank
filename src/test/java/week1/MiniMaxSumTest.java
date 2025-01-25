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
import ttg.traning.week1.miniMaxSum.MiniMaxSum;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class MiniMaxSumTest {

    @DataProvider
    public static Object[][] provideDataForTestMiniMaxSum() {

        List<Integer> input1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Long> output1 = Arrays.asList(16L, 24L);

        List<Integer> input2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Long> output2 = Arrays.asList(10L, 14L);

        return new Object[][] {
                {input1, output1},
                {input2, output2},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestMiniMaxSum")
    public void testMiniMaxSum(List<Integer> input, List<Integer> expectedOutput) {
        List<Long> actualOutput = MiniMaxSum.process(input);
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedOutput, actualOutput));
    }
}
