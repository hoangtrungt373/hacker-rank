package hackerrank.week3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week3.drawingBook.DrawingBook;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class DrawingBookTest {

    @DataProvider
    public static Object[][] provideDataForTestDrawingBook() {

        int n_1 = 5;
        int p_1 = 1;
        int output_1 = 0;

        int n_2 = 5;
        int p_2 = 2;
        int output_2 = 1;

        int n_3 = 5;
        int p_3 = 3;
        int output_3 = 1;

        int n_4 = 5;
        int p_4 = 4;
        int output_4 = 0;


        int n_5 = 5;
        int p_5 = 5;
        int output_5 = 0;

        int n_6 = 6;
        int p_6 = 2;
        int output_6 = 1;

        int n_7 = 6;
        int p_7 = 5;
        int output_7 = 1;

        int n_8 = 6;
        int p_8 = 6;
        int output_8 = 0;

        int n_9 = 18183;
        int p_9 = 18042;
        int output_9 = 70;

        int n_10 = 21235;
        int p_10 = 17;
        int output_10 = 8;

        int n_11 = 6;
        int p_11 = 3;
        int output_11 = 1;

        int n_12 = 7;
        int p_12 = 4;
        int output_12 = 1;

        return new Object[][] {
                {n_1, p_1, output_1},
                {n_2, p_2, output_2},
                {n_3, p_3, output_3},
                {n_4, p_4, output_4},
                {n_5, p_5, output_5},
                {n_6, p_6, output_6},
                {n_7, p_7, output_7},
                {n_8, p_8, output_8},
                {n_9, p_9, output_9},
                {n_10, p_10, output_10},
                {n_11, p_11, output_11},
                {n_12, p_12, output_12},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestDrawingBook")
    public void testDrawingBook(int n, int p, Integer expectedOutput) {
        Integer actualOutput = DrawingBook.process3(n, p);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
