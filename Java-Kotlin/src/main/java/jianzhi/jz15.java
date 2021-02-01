package jianzhi;

import common.datastructure.ListNode;

public class jz15 {

    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
}
