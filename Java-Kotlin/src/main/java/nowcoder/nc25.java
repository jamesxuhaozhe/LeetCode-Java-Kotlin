package nowcoder;

import common.datastructure.ListNode;

public class nc25 {

    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
