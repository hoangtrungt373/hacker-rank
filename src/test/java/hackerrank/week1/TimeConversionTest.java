package hackerrank.week1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week1.timeConversion.TimeConversion;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class TimeConversionTest {

    @DataProvider
    public static Object[][] provideDataForTestTimeConversion() {

        String input1 = "12:01:00PM";
        String output1 = "12:01:00";

        String input2 = "12:01:00AM";
        String output2 = "00:01:00";

        String input3 = "07:05:45PM";
        String output3 = "19:05:45";

        String input4 = "04:05:45AM";
        String output4 = "04:05:45";

        return new Object[][] {
                {input1, output1},
                {input2, output2},
                {input3, output3},
                {input4, output4},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestTimeConversion")
    public void testTimeConversion(String input, String expectedOutput) {
        String actualOutput = TimeConversion.process(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
