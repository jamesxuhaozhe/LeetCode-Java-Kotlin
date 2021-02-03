package jianzhi;

import common.datastructure.ListNode;

public class jz36 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode runner1 = pHead1;
        ListNode runner2 = pHead2;
        while (runner1 != runner2) {
            if (runner1 == null) {
                runner1 = pHead2;
            } else {
                runner1 = runner1.next;
            }
            if (runner2 == null) {
                runner2 = pHead1;
            } else {
                runner2 = runner2.next;
            }
        }
        return runner1;
    }
}
