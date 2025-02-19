package hackerrank.week2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.hackerrank.week2.flippingBits.FlippingBits;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class FlippingBitsTest {

    @DataProvider
    public static Object[][] provideDataForTestFlippingBits() {
        return new Object[][] {
                {3L, 4294967292L},
                {1L, 4294967294L},
                {0L, 4294967295L},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestFlippingBits")
    public void testFlippingBits(long input, long expectedFlipping) {
        long actualFlipping = FlippingBits.process(input);
        Assert.assertEquals(expectedFlipping, actualFlipping);
    }
}
