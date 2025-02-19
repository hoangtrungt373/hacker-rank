package hackerrank.week4;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week4.pickingNumbers.PickingNumbers;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class PickingNumbersTest {

    @DataProvider
    public static Object[][] provideDataForTestPickingNumbers() {

        List<Integer> list_1 = Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5);
        int output_1 = 5;

        List<Integer> list_2 = Arrays.asList(4, 6, 5, 3, 3, 1);
        int output_2 = 3; // [6, 5], [3, 3]

        return new Object[][] {
                {list_1, output_1},
                {list_2, output_2}
        };
    }


    @Test
    @UseDataProvider("provideDataForTestPickingNumbers")
    public void testPickingNumbers(List<Integer> list, Integer expectedOutput) {
        Integer actualOutput = PickingNumbers.process(list);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
