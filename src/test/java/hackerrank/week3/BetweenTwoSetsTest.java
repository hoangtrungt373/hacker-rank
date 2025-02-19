package hackerrank.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week3.betweenTwoSets.BetweenTwoSets;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class BetweenTwoSetsTest {

    @DataProvider
    public static Object[][] provideDataForTestBetweenTwoSets() {

        List<Integer> listA_1 = Arrays.asList(2, 6);
        List<Integer> listB_1 = Arrays.asList(24, 36);
        List<Integer> output_1 = Arrays.asList(6, 12);

        List<Integer> listA_2 = Arrays.asList(2, 4);
        List<Integer> listB_2 = Arrays.asList(16, 32, 96);
        List<Integer> output_2 = Arrays.asList(4, 8, 16);

        List<Integer> listA_3 = Arrays.asList(3, 4);
        List<Integer> listB_3 = Arrays.asList(24, 48);
        List<Integer> output_3 = Arrays.asList(12, 24);

        List<Integer> listA_4 = Arrays.asList(50);
        List<Integer> listB_4 = Arrays.asList(51);
        List<Integer> output_4 = new ArrayList<>();

        List<Integer> listA_5 = Arrays.asList(1);
        List<Integer> listB_5 = Arrays.asList(100);
        List<Integer> output_5 = Arrays.asList(1, 2, 4, 5, 10, 20, 25, 5, 100);

        return new Object[][] {
//                {listA_1, listB_1, output_1},
//                {listA_2, listB_2, output_2},
//                {listA_3, listB_3, output_3},
//                {listA_4, listB_4, output_4},
                {listA_5, listB_5, output_5},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestBetweenTwoSets")
    public void testBetweenTwoSets(List<Integer> listA, List<Integer> listB, List<Integer> expectedOutput) {
        List<Integer> actualOutput = BetweenTwoSets.process(listA, listB);
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedOutput, actualOutput));
    }
}
