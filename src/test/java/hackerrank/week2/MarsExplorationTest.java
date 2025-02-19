package hackerrank.week2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week2.marsExploration.MarsExploration;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class MarsExplorationTest {

    @DataProvider
    public static Object[][] provideDataForTestMarsExploration() {

        String input1 = "SOSSOT";
        int output1 = 1;

        String input2 = "SOSSPSSQSSOR";
        int output2 = 3;

        return new Object[][] {
//                {input1, output1},
                {input2, output2}
        };
    }


    @Test
    @UseDataProvider("provideDataForTestMarsExploration")
    public void testMarsExploration(String input, int expectedOutput) {
        int actualOutput = MarsExploration.process1(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
