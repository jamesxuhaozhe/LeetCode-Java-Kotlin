package jianzhi;

import common.datastructure.ListNode;

public class jz55 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode meetNode = getMeetNode(pHead);
        if (meetNode == null) {
            return null;
        }

        ListNode runner = pHead;
        while (runner != meetNode) {
            runner = runner.next;
            meetNode = meetNode.next;
        }
        return runner;
    }

    private static ListNode getMeetNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
