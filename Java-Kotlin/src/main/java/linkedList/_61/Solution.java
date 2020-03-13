package linkedList._61;

import common.datastructure.ListNode;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        // just do nothing
        if (k == 0) {
            return head;
        }

        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode lastNode = null;

        // find the length of the list
        int len = 0;
        while (curr != null) {
            if (curr.next == null) {
                // grab the pointer to the last node
                lastNode = curr;
            }
            curr = curr.next;
            len++;
        }

        // just do nothing
        if (k >= len && len % k == 0) {
            return head;
        }

        // find the real k we need to rotate
        if (k > len) {
            k = k % len;
        }

        int moves = len - k;
        // move the pointer to just one node before the node in question
        curr = head;
        while (moves-- > 1) {
            curr = curr.next;
        }

        // have the last node point to the head
        lastNode.next = head;
        ListNode newHead = curr.next;

        // have the cut node point to null
        curr.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode result = new Solution().rotateRight(node1, 4);

        System.out.println(result);
    }
}
