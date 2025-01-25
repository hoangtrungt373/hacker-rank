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
import ttg.traning.week1.plusMinus.PlusMinus;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class PlusMinusTest {

    @DataProvider
    public static Object[][] provideDataForTestPlusMinus() {

        List<Integer> input1 = Arrays.asList(1, 1, 0, -1, -1);
        List<Double> output1 = Arrays.asList(0.400000, 0.400000, 0.200000);

        List<Integer> input2 = Arrays.asList(-4, 3, -9, 0, 4, 1);
        List<Double> output2 = Arrays.asList(0.500000, 0.333333, 0.166667);
        return new Object[][] {
                {input1, output1},
                {input2, output2},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestPlusMinus")
    public void testPlusMinus(List<Integer> input, List<Double> expectedOutput) {
        List<Double> actualOutput = PlusMinus.process(input);
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedOutput, actualOutput));
    }
}
