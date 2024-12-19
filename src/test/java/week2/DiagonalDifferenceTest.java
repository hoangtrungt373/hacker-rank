package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week2.diagonalDifference.DiagonalDifference;
import ttg.traning.week2.flippingBits.FlippingBits;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class DiagonalDifferenceTest {

    @DataProvider
    public static Object[][] provideDataForTestDiagonalDifference() {
        List<List<Integer>> matrix1 = new ArrayList<List<Integer>>();
        matrix1.add(Arrays.asList(1, 2, 3));
        matrix1.add(Arrays.asList(4, 5, 6));
        matrix1.add(Arrays.asList(9, 8, 9));
        int absoluteDiagonalDifference1 = 2;

        List<List<Integer>> matrix2 = new ArrayList<List<Integer>>();
        matrix2.add(Arrays.asList(11, 2, 4));
        matrix2.add(Arrays.asList(4, 5, 6));
        matrix2.add(Arrays.asList(10, 8, -12));
        int absoluteDiagonalDifference2 = 15;

        return new Object[][] {
                {matrix1, absoluteDiagonalDifference1},
                {matrix2, absoluteDiagonalDifference2},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestDiagonalDifference")
    public void testDiagonalDifference(List<List<Integer>> matrix, int expectedAbsoluteDiagonalDifference) {
        long actualAbsoluteDiagonalDifference = DiagonalDifference.process(matrix);
        Assert.assertEquals(expectedAbsoluteDiagonalDifference, actualAbsoluteDiagonalDifference);
    }
}
