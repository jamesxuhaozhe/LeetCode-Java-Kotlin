package jianzhi;

import common.datastructure.ListNode;

public class jz16 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;
        ListNode p1Runner = list1;
        ListNode p2Runner = list2;
        while (p1Runner != null && p2Runner != null) {
            if (p1Runner.val < p2Runner.val) {
                runner.next = p1Runner;
                p1Runner = p1Runner.next;
            } else {
                runner.next = p2Runner;
                p2Runner = p2Runner.next;
            }
            runner = runner.next;
        }

        if (p1Runner != null) {
            runner.next = p1Runner;
        }

        if (p2Runner != null) {
            runner.next = p2Runner;
        }

        return dummy.next;
    }
}
