package hot100;

import common.datastructure.ListNode;

public class lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode runnerA = headA;
        ListNode runnerB = headB;
        while (runnerA != runnerB) {
            if (runnerA == null) {
                runnerA = headB;
            } else {
                runnerA = runnerA.next;
            }
            if (runnerB == null) {
                runnerB = headA;
            } else {
                runnerB = runnerB.next;
            }
        }
        return runnerA;
    }
}
