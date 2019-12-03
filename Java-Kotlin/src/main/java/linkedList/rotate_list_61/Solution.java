package linkedList.rotate_list_61;

import datastructure.ListNode;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }

        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode lastNode = null;

        int len = 0;
        while (curr != null) {
            if (curr.next == null) {
                lastNode = curr;
            }
            curr = curr.next;
            len++;
        }

        if (k >= len && len % k == 0) {
            return head;
        }

        if (k > len) {
            k = k % len;
        }

        int moves = len - k;
        curr = head;
        while (moves-- > 1) {
            curr = curr.next;
        }

        lastNode.next = head;
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        //ListNode node4 = new ListNode(4);
        //ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode result = new Solution().rotateRight(node1, 4);

        System.out.println(result);
    }
}
