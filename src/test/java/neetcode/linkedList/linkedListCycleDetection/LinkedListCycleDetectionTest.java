package neetcode.linkedList.linkedListCycleDetection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import ttg.traning.neetcode.dto.ListNode;
import ttg.traning.neetcode.linkedList.linkedListCycleDetection.LinkedListCycleDetection;

/**
 * Tests for {@link LinkedListCycleDetection}.
 *
 * @author ttg
 */
@RunWith(DataProviderRunner.class)
public class LinkedListCycleDetectionTest {

    @DataProvider
    public static Object[][] provideDataForHasCycle() {
        return new Object[][] {
                // Examples from problem statement
                {new int[] {1, 2, 3, 4}, 1, true},
                {new int[] {1, 2}, -1, false},

                // Edge cases
                {new int[] {}, -1, false},
                {new int[] {42}, -1, false},
                {new int[] {42}, 0, true},

                // More cases
                {new int[] {1, 2, 3}, 0, true},   // tail connects to head
                {new int[] {1, 2, 3}, 2, true},   // self-cycle at tail
                {new int[] {1, 2, 1}, -1, false},
                {new int[] {-1, -2, -3, -4}, 2, true},
                {new int[] {-1, -2, -3, -4}, -1, false},
        };
    }

    @Test
    @UseDataProvider("provideDataForHasCycle")
    public void testHasCycle(int[] values, int index, boolean expected) {
        LinkedListCycleDetection solver = new LinkedListCycleDetection();
        ListNode head = buildListWithOptionalCycle(values, index);

        boolean actual = solver.hasCycle(head);

        Assert.assertEquals(expected, actual);
    }

    /**
     * Builds a singly linked list from {@code values}. If {@code index >= 0}, the tail's next pointer is
     * connected to the node at {@code index} (0-indexed), creating a cycle.
     */
    private static ListNode buildListWithOptionalCycle(int[] values, int index) {
        if (values.length == 0) {
            return null;
        }
        if (index < -1 || index >= values.length) {
            throw new IllegalArgumentException("index must be -1 or within [0, values.length - 1]");
        }

        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }

        if (index != -1) {
            nodes[values.length - 1].next = nodes[index];
        }
        return nodes[0];
    }
}
