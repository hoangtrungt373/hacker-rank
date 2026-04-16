package ttg.traning.neetcode.linkedList.linkedListCycleDetection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ttg.traning.neetcode.dto.ListNode;

/**
 *
 * @author ttg
 */
public class LinkedListCycleDetection {
    public boolean hasCycleV2(ListNode head) {
        Set<ListNode> existing = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            if (existing.contains(temp)) {
                return true;
            }
            existing.add(temp);
            curr = temp;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode curr1 = head;
        ListNode curr2 = head;
        while (curr1 != null && curr2 != null) {
            ListNode temp = curr1.next;
            if (curr2.next == null) {
                return false;
            }
            ListNode temp2 = curr2.next.next;
            if (temp.equals(temp2)) {
                return true;
            }
            curr1 = temp;
            curr2 = temp2;
        }
        return false;
    }

    public boolean hasCycleV3(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

}
