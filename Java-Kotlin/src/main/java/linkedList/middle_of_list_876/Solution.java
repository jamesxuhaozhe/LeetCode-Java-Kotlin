package linkedList.middle_of_list_876;

import common.datastructure.ListNode;

public class Solution {

    public ListNode middleNode(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        int len = 0;
        ListNode curr = head;
        while (head != null) {
            head = head.next;
            len++;
        }

        int move = len / 2;
        while (move-- > 0) {
            curr = curr.next;
        }

        return curr;
    }
}
