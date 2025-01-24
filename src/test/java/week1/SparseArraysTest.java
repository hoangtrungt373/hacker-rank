package week1;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week1.sparseArrays.SparseArrays;
import ttg.traning.week2.loneLyInteger.LonelyInteger;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class SparseArraysTest {

    @DataProvider
    public static Object[][] provideDataForTestSparseArrays() {

        List<String> strings = Arrays.asList("aba", "baba", "aba", "xzxb");
        List<String> queries = Arrays.asList("aba", "xzxb", "ab");

        List<Integer> output = Arrays.asList(2, 1, 0);

        return new Object[][] {
                {strings, queries, output},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestSparseArrays")
    public void testSparseArrays(List<String> strings, List<String> queries, List<Integer> expectedOutput) {
        List<Integer> actualOutput = SparseArrays.process(strings, queries);
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedOutput, actualOutput));
    }
}
