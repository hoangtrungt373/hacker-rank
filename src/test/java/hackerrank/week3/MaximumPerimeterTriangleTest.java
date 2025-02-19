package hackerrank.week3;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week3.maximumPerimeterTriangle.MaximumPerimeterTriangle;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class MaximumPerimeterTriangleTest {

    @DataProvider
    public static Object[][] provideDataForTestMaximumPerimeterTriangleTest() {

        List<Integer> input_1 = Arrays.asList(1, 2, 3, 4, 5, 10);
        List<Integer> output_1 = Arrays.asList(3, 4, 5);

        List<Integer> input_2 = Arrays.asList(1, 1, 1, 3, 3);
        List<Integer> output_2 = Arrays.asList(1, 3, 3);

        List<Integer> input_3 = Arrays.asList(1, 2, 3);
        List<Integer> output_3 = Arrays.asList(-1);

        return new Object[][] {
                {input_1, output_1},
                {input_2, output_2},
                {input_3, output_3},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestMaximumPerimeterTriangleTest")
    public void testMaximumPerimeterTriangle(List<Integer> input, List<Integer> expectedOutput) {
        List<Integer> actualOutput = MaximumPerimeterTriangle.process(input);
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedOutput, actualOutput));
    }
}
