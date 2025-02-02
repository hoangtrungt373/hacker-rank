package week3;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week3.permutingTwoArrays.PermutingTwoArrays;
import ttg.traning.week3.subarrayDivision2.SubarrayDivision2;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class SubarrayDivision2Test {

    @DataProvider
    public static Object[][] provideDataForTestSubarrayDivision2() {

        List<Integer> list_1 = Arrays.asList(2, 2, 1, 3, 2);
        int d_1 = 4;
        int m_1 = 2;
        int output_1 = 2; // [2, 2], [1, 3]

        List<Integer> list_2 = Arrays.asList(4);
        int d_2 = 4;
        int m_2 = 1;
        int output_2 = 1; // [4]

        List<Integer> list_3 = Arrays.asList(2, 3, 4, 4, 2, 1, 2, 5, 3, 4, 4, 3, 4, 1, 3, 5, 4, 5, 3, 1, 1, 5, 4, 3, 5,
                3, 5, 3, 4, 4, 2, 4, 5, 2, 3, 2, 5, 3, 4, 2, 4, 3, 3, 4, 3, 5, 2, 5, 1, 3, 1, 4, 2, 2, 4, 3, 3, 3, 3, 4,
                1, 1, 4, 3, 1, 5, 2, 5, 1, 3, 5, 4, 3, 3, 1, 5, 3, 3, 3, 4, 5, 2);
        int d_3 = 26;
        int m_3 = 8;
        int output_3 = 16;

        return new Object[][] {
                {list_1, d_1, m_1, output_1},
                {list_2, d_2, m_2, output_2},
                {list_3, d_3, m_3, output_3}
        };
    }


    @Test
    @UseDataProvider("provideDataForTestSubarrayDivision2")
    public void testSubarrayDivision2(List<Integer> list, Integer d, Integer m, Integer expectedOutput) {
        Integer actualOutput = SubarrayDivision2.process1(list, d, m);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
