package linkedList._19;

import common.datastructure.ListNode;

public class Solution2 {

    /**
     * slow and fast pointers problem. have two pointers, slow and fast, fast moves n steps first, then move fast and slow
     * together til fast reaches null, then slow will be at the node we want delete.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = head;

        // first need to move fast pointer by n steps ahead
        int fastMoves = n;
        while (fastMoves-- > 0) {
            fast = fast.next;
        }

        // this is the case where the element needed to be removed is the first node.
        if (fast == null) {
            dummy.next = dummy.next.next;
            return dummy.next;
        }

        // move fast pointer forward by one step so that by the time fast pointer reaches null,
        // slow pointer will be at the previous node to the node we want delete
        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // remove the node in question
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }
}
