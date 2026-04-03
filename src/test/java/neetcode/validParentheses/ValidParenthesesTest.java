package neetcode.validParentheses;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.validParentheses.ValidParentheses;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class ValidParenthesesTest {

    @DataProvider
    public static Object[][] provideDataForIsValid() {
        return new Object[][] {
                // Examples from problem statement
                {"[]", true},
                {"([{}])", true},
                {"[(])", false},

                // More cases
                {"()", true},
                {"()[]{}", true},
                {"(]", false},
                {"([)]", false},
                {"{[]}", true},
                {"(", false},
                {")", false},
                {"((", false},
                {"([{}])(){}", true}
        };
    }

    @Test
    @UseDataProvider("provideDataForIsValid")
    public void testIsValid(String s, boolean expected) {
        ValidParentheses solver = new ValidParentheses();
        boolean actual = solver.isValid(s);

        Assert.assertEquals(expected, actual);
    }
}
