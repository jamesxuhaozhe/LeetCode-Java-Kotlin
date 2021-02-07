package jianzhi;

import common.datastructure.ListNode;

public class jz56 {

    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.val == cur.val) {
                    temp = temp.next;
                }
                prev.next = temp;
                cur = temp;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
