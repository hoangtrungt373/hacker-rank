package week2;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week2.countingValleys.CountingValleys;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class CountingValleysTest {

    @DataProvider
    public static Object[][] provideDataForTestCountingValleys() {

        String path1 = "DDUUDDUDUUUD";
        int countValleys1 = 2;

        String path2 = "UDDDUDUU";
        int countValleys2 = 1;

        return new Object[][] {
                {path1, countValleys1},
                {path2, countValleys2},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestCountingValleys")
    public void testCountingValleys(String path, Integer expectedCountValleys) {
        Integer actualCountValleys = CountingValleys.process1(path);
        Assert.assertEquals(expectedCountValleys, actualCountValleys);
    }
}
