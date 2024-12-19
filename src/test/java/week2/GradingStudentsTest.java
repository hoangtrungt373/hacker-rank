package week2;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.week2.gradingStudents.GradingStudents;

/**
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class GradingStudentsTest {

    @DataProvider
    public static Object[][] provideDataForTestGradingStudents() {
        return new Object[][] {
                {List.of(4, 73, 67, 38, 33), 40, 3, List.of(4, 75, 67, 40, 33)},
                {List.of(84, 29, 57), 40, 3, List.of(85, 29, 57)},
        };
    }


    @Test
    @UseDataProvider("provideDataForTestGradingStudents")
    public void testGradingStudents(List<Integer> grades, Integer failingGrade, Integer maxDiffAllow, List<Integer> expectedRoudingGrades) {
        List<Integer> actualRoudingGrades = GradingStudents.process(grades, failingGrade, maxDiffAllow);
        Assert.assertTrue(CollectionUtils.isEqualCollection(expectedRoudingGrades, actualRoudingGrades));
    }
}
