package hot100;

import common.datastructure.ListNode;

public class lc21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode runner = new ListNode(-1);
        ListNode dummy = runner;
        ListNode l1Runner = l1;
        ListNode l2Runner = l2;
        while (l1Runner != null && l2Runner != null) {
            if (l1Runner.val < l2Runner.val) {
                runner.next = l1Runner;
                l1Runner = l1Runner.next;
            } else {
                runner.next = l2Runner;
                l2Runner = l2Runner.next;
            }
            runner = runner.next;
        }

        while (l1Runner != null) {
            runner.next = l1Runner;
            l1Runner = l1Runner.next;
            runner = runner.next;
        }

        while (l2Runner != null) {
            runner.next = l2Runner;
            l2Runner = l2Runner.next;
            runner = runner.next;
        }
        return dummy.next;
    }
}
