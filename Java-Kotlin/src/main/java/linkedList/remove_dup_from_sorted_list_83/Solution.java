package linkedList.remove_dup_from_sorted_list_83;

import datastructure.ListNode;

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
