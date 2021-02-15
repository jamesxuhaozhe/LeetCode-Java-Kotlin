package hot100;

import common.datastructure.ListNode;

public class lc206 {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode next = null;
        ListNode runner = head;
        while (runner != null) {
            next = runner.next;
            runner.next = newHead;
            newHead = runner;
            runner = next;
        }
        return newHead;
    }
}
