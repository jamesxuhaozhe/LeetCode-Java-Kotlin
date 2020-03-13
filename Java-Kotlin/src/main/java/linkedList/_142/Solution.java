package linkedList._142;

import common.datastructure.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Time and Space complexity: O(n)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) {
                return head;
            }
            visited.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode intersectionNode = getIntersectionNode(head);
        if (intersectionNode == null) {
            return null;
        }

        while (head != intersectionNode) {
            head = head.next;
            intersectionNode = intersectionNode.next;
        }

        return head;
    }

    private ListNode getIntersectionNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createSinglyLinkedList(Arrays.asList(1, 2, 3));
        int count = 0;
        while (head.next != null) {
            count++;
            head = head.next;
        }

        System.out.println(count);
    }
}
