package week2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week2.flippingMatrix.FlippingMatrix;
import ttg.traning.week2.pangrams.Pangrams;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class FlippingMatrixTest {

    @DataProvider
    public static Object[][] provideDataForTestFlippingMatrix() {

        List<List<Integer>> input1 = new ArrayList<List<Integer>>();
        input1.add(List.of(1, 2));
        input1.add(List.of(3, 4));
        int output1 = 4;

        List<List<Integer>> input2 = new ArrayList<List<Integer>>();
        input2.add(List.of(112, 42, 83, 119));
        input2.add(List.of(56, 125, 56, 49));
        input2.add(List.of(15, 78, 101, 43));
        input2.add(List.of(62, 98, 114, 108));
        int output2 = 414;

        List<List<Integer>> input3 = new ArrayList<List<Integer>>();
        input3.add(List.of(107, 54, 128, 15));
        input3.add(List.of(12, 75, 110, 138));
        input3.add(List.of(100, 96, 34, 85));
        input3.add(List.of(75, 15, 28, 112));
        int output3 = 488;

        return new Object[][] {
                {input1, output1},
                {input2, output2},
                {input3, output3}
        };
    }


    @Test
    @UseDataProvider("provideDataForTestFlippingMatrix")
    public void testFlippingMatrix(List<List<Integer>> input, int expectedOutput) {
        int actualOutput = FlippingMatrix.process(input);
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
