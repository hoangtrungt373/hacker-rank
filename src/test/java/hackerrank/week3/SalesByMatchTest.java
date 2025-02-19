package hackerrank.week3;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week3.salesByMatch.SalesByMatch;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class SalesByMatchTest {

    @DataProvider
    public static Object[][] provideDataForTestSalesByMatch() {

        List<Integer> list_1 = Arrays.asList(1, 2, 1, 2, 1, 3, 2);
        int output_1 = 2;

        List<Integer> list_2 = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        int output_2 = 3;

        return new Object[][] {
                {list_1, output_1},
                {list_2, output_2},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestSalesByMatch")
    public void testSalesByMatch(List<Integer> list, Integer expectedOutput) {
        Integer actualOutput = SalesByMatch.process1(list);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
