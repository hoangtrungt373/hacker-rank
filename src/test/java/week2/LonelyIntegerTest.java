package week2;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week2.LoneLyInteger.LonelyInteger;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class LonelyIntegerTest {

    @DataProvider
    public static Object[][] provideDataForTestLonelyInteger() {
        return new Object[][] {
                {List.of(1, 2, 3, 4, 3, 2, 1, 3), 4},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestLonelyInteger")
    public void testLonelyInteger(List<Integer> inputs, Integer expectedOutput) {
        Integer actualOutput = LonelyInteger.process(inputs);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
