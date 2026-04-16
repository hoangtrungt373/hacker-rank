package neetcode.linkedList.reverseLinkedList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.dto.ListNode;
import ttg.traning.neetcode.linkedList.reverseLinkedList.ReverseLinkedList;

/**
 * Tests for {@link ReverseLinkedList}.
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class ReverseLinkedListTest {

    @DataProvider
    public static Object[][] provideDataForReverseList() {
        return new Object[][] {
                // Examples from problem statement
                {new int[] {0, 1, 2, 3}, new int[] {3, 2, 1, 0}},
                {new int[] {}, new int[] {}},

                // Edge cases
                {new int[] {5}, new int[] {5}},
                {new int[] {-1, -2, -3}, new int[] {-3, -2, -1}},
                {new int[] {10, 20}, new int[] {20, 10}},
        };
    }

    @Test
    @UseDataProvider("provideDataForReverseList")
    public void testReverseList(int[] values, int[] expected) {
        ReverseLinkedList solver = new ReverseLinkedList();
        ListNode head = buildList(solver, values);

        ListNode reversed = solver.reverseList(head);

        assertListEquals(expected, reversed);
    }

    private static ListNode buildList(ReverseLinkedList solver, int[] values) {
        ListNode head = null;
        ListNode current = null;
        for (int value : values) {
            ListNode node = new ListNode(value);
            if (head == null) {
                head = node;
            } else {
                current.next = node;
            }
            current = node;
        }
        return head;
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
