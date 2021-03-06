package linkedList._83;

import common.datastructure.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);

        dummy.next = head;
        while (head != null) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
