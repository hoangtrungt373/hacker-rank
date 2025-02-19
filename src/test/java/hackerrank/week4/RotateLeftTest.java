
package hackerrank.week4;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week4.rotateLeft.RotateLeft;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class RotateLeftTest {

    @DataProvider
    public static Object[][] provideDataForTestRotateLeft() {

        List<Integer> list_1 = Arrays.asList(1, 2, 3, 4, 5);
        int d_1 = 2;
        List<Integer> output_1 = Arrays.asList(3, 4, 5, 1, 2);

        List<Integer> list_2 = Arrays.asList(1, 2, 3, 4, 5);
        int d_2 = 4;
        List<Integer> output_2 = Arrays.asList(5, 1, 2, 3, 4);

        return new Object[][] {
                {list_1, d_1, output_1},
                {list_2, d_2, output_2}
        };
    }


    @Test
    @UseDataProvider("provideDataForTestRotateLeft")
    public void testRotateLeft(List<Integer> list, int d, List<Integer> expectedOutput) {
        List<Integer> actualOutput = RotateLeft.process(d, list);
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedOutput, actualOutput));
    }
}
