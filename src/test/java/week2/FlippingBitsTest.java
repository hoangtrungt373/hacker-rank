package week2;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week2.GradingStudents.GradingStudents;
import ttg.traning.week2.flippingBits.FlippingBits;

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
