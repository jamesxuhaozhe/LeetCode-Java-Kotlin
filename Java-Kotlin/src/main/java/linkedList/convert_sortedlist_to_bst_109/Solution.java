package linkedList.convert_sortedlist_to_bst_109;

import common.datastructure.TreeNode;
import common.datastructure.ListNode;

public class Solution {

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
}
