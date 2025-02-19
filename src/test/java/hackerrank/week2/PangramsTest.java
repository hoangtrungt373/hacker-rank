package hackerrank.week2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week2.pangrams.Pangrams;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class PangramsTest {

    @DataProvider
    public static Object[][] provideDataForTestPangrams() {

        String input1 = "We promptly judged antique ivory buckles for the next prize";
        boolean output1 = true;

        String input2 = "We promptly judged antique ivory buckles for the prize";
        boolean output2 = false;

        return new Object[][] {
                {input1, output1},
                {input2, output2}
        };
    }


    @Test
    @UseDataProvider("provideDataForTestPangrams")
    public void testPangrams(String input, boolean expectedOutput) {
        boolean actualOutput = Pangrams.process(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
