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

import ttg.traning.week1.findTheMedian.FindTheMedian;
import ttg.traning.week1.plusMinus.PlusMinus;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class FindTheMedianTest {

    @DataProvider
    public static Object[][] provideDataForTestFindTheMedian() {

        List<Integer> input1 = Arrays.asList(5, 3, 1, 2, 4);
        double output1 = 3.0;

        List<Integer> input2 = Arrays.asList(0, 1, 2, 4, 6, 5, 3);
        double output2 = 3.0;
        return new Object[][] {
                {input1, output1},
                {input2, output2},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestFindTheMedian")
    public void testFindTheMedian(List<Integer> input, Double expectedOutput) {
        Double actualOutput = FindTheMedian.process1(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
