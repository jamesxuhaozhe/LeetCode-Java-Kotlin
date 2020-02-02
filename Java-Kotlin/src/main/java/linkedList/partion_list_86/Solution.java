package linkedList.partion_list_86;

import common.datastructure.ListNode;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode less = new ListNode(-1);
        ListNode greater = new ListNode(-1);

        ListNode left = less;
        ListNode right = greater;
        less.next = head;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        less.next = right.next;
        return left.next;
    }
}
