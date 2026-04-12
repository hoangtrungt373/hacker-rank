package neetcode.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.groupAnagrams.GroupAnagrams;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class GroupAnagramsTest {

    @DataProvider
    public static Object[][] provideDataForGroupAnagrams() {
        return new Object[][] {
                // Examples from problem statement
                {
                        new String[] {"act", "pots", "tops", "cat", "stop", "hat"},
                        Arrays.asList(
                                Arrays.asList("hat"),
                                Arrays.asList("act", "cat"),
                                Arrays.asList("stop", "pots", "tops"))
                },
                {
                        new String[] {"x"},
                        Arrays.asList(Arrays.asList("x"))
                },
                {
                        new String[] {""},
                        Arrays.asList(Arrays.asList(""))
                },

                // More cases
                {
                        new String[] {"", "", "a"},
                        Arrays.asList(
                                Arrays.asList("", ""),
                                Arrays.asList("a"))
                },
                {
                        new String[] {"eat", "tea", "tan", "ate", "nat", "bat"},
                        Arrays.asList(
                                Arrays.asList("eat", "tea", "ate"),
                                Arrays.asList("tan", "nat"),
                                Arrays.asList("bat"))
                },
                {
                        new String[] {"abc", "bca", "cab", "abc"},
                        Arrays.asList(Arrays.asList("abc", "bca", "cab", "abc"))
                }
        };
    }

    @Test
    @UseDataProvider("provideDataForGroupAnagrams")
    public void testGroupAnagrams(String[] strs, List<List<String>> expected) {
        String[] input = strs.clone();

        GroupAnagrams solver = new GroupAnagrams();
        List<List<String>> actual = solver.groupAnagramsV2(input);

        Assert.assertEquals(canonicalize(expected), canonicalize(actual));
    }

    private static List<String> canonicalize(List<List<String>> groups) {
        List<String> canonical = new ArrayList<>();
        for (List<String> group : groups) {
            List<String> sortedGroup = new ArrayList<>(group);
            Collections.sort(sortedGroup);
            canonical.add(String.join("|", sortedGroup));
        }
        Collections.sort(canonical);
        return canonical;
    }
}
