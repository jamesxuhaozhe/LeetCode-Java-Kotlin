package linkedList.reverse_linkedlist_iii_92;

import datastructure.ListNode;

import java.util.Arrays;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode end = start;
        for (int i = 0; i < n - m; i++) {
            end = end.next;
        }
        ListNode headOfRemained = end.next;
        end.next = null;
        pre.next = reverse(start);
        start.next = headOfRemained;
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createSinglyLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        Solution solution = new Solution();
        ListNode.printList(solution.reverseBetween(head, 2, 4));
        System.out.printf("end");
    }
}
