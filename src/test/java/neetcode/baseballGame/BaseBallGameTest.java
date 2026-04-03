package neetcode.baseballGame;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.baseballGame.BaseBallGame;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class BaseBallGameTest {

    @DataProvider
    public static Object[][] provideDataForCalPoints() {
        return new Object[][] {
                // Examples from prompt
                {new String[] {"1", "2", "+", "C", "5", "D"}, 18},
                {new String[] {"5", "D", "+", "C"}, 15},

                // Common valid patterns
                {new String[] {"5", "-2", "4", "C", "D", "9", "+", "+"}, 27},
                {new String[] {"10"}, 10},
                {new String[] {"3", "D"}, 9},
                {new String[] {"7", "8", "+"}, 30}
        };
    }

    @Test
    @UseDataProvider("provideDataForCalPoints")
    public void testCalPoints(String[] operations, int expected) {
        BaseBallGame solver = new BaseBallGame();
        int actual = solver.calPoints(operations);

        Assert.assertEquals(expected, actual);
    }
}
