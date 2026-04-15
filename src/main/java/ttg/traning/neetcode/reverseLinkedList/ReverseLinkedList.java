package ttg.traning.neetcode.reverseLinkedList;

import ttg.traning.neetcode.dto.ListNode;

/**
 *
 * @author ttg
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
