package neetcode.linkedList.mergeTwoLists;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.dto.ListNode;
import ttg.traning.neetcode.linkedList.mergeTwoLists.MergeTwoLists;

/**
 * Tests for {@link MergeTwoLists}.
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class MergeTwoListsTest {

    @DataProvider
    public static Object[][] provideDataForMergeTwoLists() {
        return new Object[][] {
                // Examples from problem statement
                {new int[] {1, 2, 4}, new int[] {1, 3, 5}, new int[] {1, 1, 2, 3, 4, 5}},
//                {new int[] {}, new int[] {1, 2}, new int[] {1, 2}},
//                {new int[] {}, new int[] {}, new int[] {}},
//
//                // Additional edge cases
//                {new int[] {1}, new int[] {}, new int[] {1}},
//                {new int[] {1, 3, 5}, new int[] {2, 4, 6}, new int[] {1, 2, 3, 4, 5, 6}},
//                {new int[] {-5, -2, 0}, new int[] {-4, -3, 1}, new int[] {-5, -4, -3, -2, 0, 1}},
//                {new int[] {1, 1, 2}, new int[] {1, 3, 3}, new int[] {1, 1, 1, 2, 3, 3}},
        };
    }

    @Test
    @UseDataProvider("provideDataForMergeTwoLists")
    public void testMergeTwoLists(int[] list1Values, int[] list2Values, int[] expected) {
        MergeTwoLists solver = new MergeTwoLists();
        ListNode list1 = buildList(list1Values);
        ListNode list2 = buildList(list2Values);

        ListNode actual = solver.mergeTwoLists(list1, list2);

        assertListEquals(expected, actual);
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    private static void assertListEquals(int[] expected, ListNode head) {
        ListNode current = head;
        int index = 0;
        while (current != null && index < expected.length) {
            Assert.assertEquals("value mismatch at index " + index, expected[index], current.val);
            current = current.next;
            index++;
        }
        Assert.assertEquals("list length mismatch", expected.length, index);
        Assert.assertNull("list should end after expected length", current);
    }
}
