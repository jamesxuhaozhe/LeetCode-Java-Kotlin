package linkedList._147;

import common.datastructure.ListNode;

import java.util.Arrays;

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            while (pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }
            curr.next = pre.next;
            pre.next = curr;
            pre = dummy;
            curr = next;
        }

        return dummy.next;
    }

    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode tail = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (tail.val < curr.val) {
                tail.next = curr;
                tail = curr;
                curr = curr.next;
            } else {
                ListNode next = curr.next;
                tail.next = next;
                while (pre.next != null && pre.next.val < curr.val) {
                    pre = pre.next;
                }
                curr.next = pre.next;
                pre.next = curr;
                pre = dummy;
                curr = next;
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = ListNode.createSinglyLinkedList(Arrays.asList(1));

        ListNode.printList(solution.insertionSortList(head));
    }
}
