package linkedList._203;

import common.datastructure.ListNode;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while(curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
