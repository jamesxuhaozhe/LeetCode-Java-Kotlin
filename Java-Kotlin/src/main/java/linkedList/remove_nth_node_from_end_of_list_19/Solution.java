package linkedList.remove_nth_node_from_end_of_list_19;

import datastructure.ListNode;

public class Solution {

    /**
     * traverse once to get the length of the list.
     * if the length happens to be equal to n, then return head.next
     * then calculate the delta, which are moves of the temp pointer,
     * remove the nth node by temp.next = temp.next.next
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;

        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        if (len == n) {
            return head.next;
        }

        int move = len - n;
        temp = head;
        while (move-- > 1) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            return head;
        }

        return null;
    }
}
