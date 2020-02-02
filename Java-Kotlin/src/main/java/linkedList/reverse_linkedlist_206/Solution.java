package linkedList.reverse_linkedlist_206;

import common.datastructure.ListNode;

/**
 * Problem link: https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }
}
