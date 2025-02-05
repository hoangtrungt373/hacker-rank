package week3;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week3.migratoryBirds.MigratoryBirds;
import ttg.traning.week3.subarrayDivision2.SubarrayDivision2;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class MigratoryBirdsTest {

    @DataProvider
    public static Object[][] provideDataForTestMigratoryBirds() {

        List<Integer> list_1 = Arrays.asList(1, 1, 2, 2, 3);
        int output_1 = 1;

        List<Integer> list_2 = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);
        int output_2 = 3;

        return new Object[][] {
                {list_1, output_1},
                {list_2, output_2},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestMigratoryBirds")
    public void testMigratoryBirds(List<Integer> list, Integer expectedOutput) {
        Integer actualOutput = MigratoryBirds.process1(list);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
