package linkedList.split_list_in_parts_725;

import common.datastructure.ListNode;

public class Solution {

    /**
     * 时间复杂度：O(N + k)。N 指的是链表的结点数，若 k 很大，则还需要添加许多空列表。
     * 空间复杂度：O(max(N, k))，存放答案所需的空间。
     *
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = getLength(root);

        int avg = len / k;
        int remainder = len % k;

        ListNode[] ans = new ListNode[k];
        ListNode curr = root;
        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(-1);
            ListNode dummyRunner = dummy;
            // avg + (i < remainder ? 1 : 0)
            for (int j = 0; j < avg + (i < remainder ? 1 : 0); j++) {
                dummyRunner.next = new ListNode(curr.val);
                dummyRunner = dummyRunner.next;
                if (curr != null) {
                    curr = curr.next;
                }
            }
            ans[i] = dummy.next;
        }

        return ans;
    }

    private int getLength(ListNode root) {
        ListNode curr = root;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public ListNode[] splitListToParts1(ListNode root, int k) {
        int len = getLength(root);

        int avg = len / k;
        int remainder = len % k;

        ListNode[] ans = new ListNode[k];
        ListNode curr = root;
        for (int i = 0; i < k; i++) {
            ListNode head = curr;
            for (int j = 0; j < avg + (i < remainder ? 1 : 0) - 1; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (curr != null) {
                ListNode pre = curr;
                curr = curr.next;
                pre.next = null;
            }
            ans[i] = head;
        }

        return ans;
    }
}
