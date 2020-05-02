package linkedList._143;

import common.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Time Complexity: O(n)
     * <p>
     * Space complexity: O(1)
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode middle = findMiddleNode(head);

        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;

        right = reverse(right);

        merge(left, right);
    }

    private ListNode reverse(ListNode head) {
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

    private void merge(ListNode left, ListNode right) {
        ListNode leftNext;
        ListNode rightNext;
        while (left.next != null && right != null) {
            leftNext = left.next;
            rightNext = right.next;

            left.next = right;
            right.next = leftNext;

            left = leftNext;
            right = rightNext;
        }
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * Space complexity: O(n)
     * <p>
     * Time complexity: O(n)
     *
     * @param head
     */
    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            // if the size is even, then early break
            if (left == right) {
                break;
            }

            list.get(right).next = list.get(left);
            right--;
        }

        list.get(left).next = null;
    }

}
