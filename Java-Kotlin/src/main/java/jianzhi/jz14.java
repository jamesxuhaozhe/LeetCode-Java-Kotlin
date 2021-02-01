package jianzhi;

import common.datastructure.ListNode;

public class jz14 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = getLen(head);
        if (k > length) {
            return null;
        }

        ListNode node = head;
        for (int i = 0; i < length - k; i++) {
            node = node.next;
        }
        return node;
    }

    private int getLen(ListNode head) {
        ListNode runner = head;
        int count = 0;
        while (runner != null) {
            count++;
            runner = runner.next;
        }

        return count;
    }
}
