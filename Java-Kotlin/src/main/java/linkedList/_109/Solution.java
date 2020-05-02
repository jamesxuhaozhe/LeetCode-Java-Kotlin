package linkedList._109;

import common.datastructure.ListNode;
import common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Time complexity: O(nlogn)
     * <p>
     * Space complexity: O(logn)
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        // base case 1:
        if (head == null) {
            return null;
        }

        ListNode mid = findMiddleNode(head);
        TreeNode root = new TreeNode(mid.val);

        // base case 2: if the list just has one element
        if (mid == head) {
            return root;
        }

        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(mid.next);
        root.left = left;
        root.right = right;
        return root;
    }

    private static ListNode findMiddleNode(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // handle the base case
        if (pre != null) {
            pre.next = null;
        }

        return slow;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST1(ListNode head) {
        addToList(head);
        return convertToBST(0, sortedList.size() - 1);
    }

    public TreeNode convertToBST(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        int value = sortedList.get(mid);

        TreeNode root = new TreeNode(value);
        if (left == right) {
            return root;
        }

        TreeNode leftTree = convertToBST(left, mid - 1);
        TreeNode rightTree = convertToBST(mid + 1, right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    private List<Integer> sortedList = new ArrayList<>();

    private void addToList(ListNode head) {
        while (head != null) {
            sortedList.add(head.val);
            head = head.next;
        }
    }
}
