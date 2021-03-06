package linkedList._23;

import common.datastructure.ListNode;

import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode pre = new ListNode(-1);
        ListNode temp = pre;

        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            temp.next = new ListNode(curr.val);
            if (curr.next != null) {
                heap.offer(curr.next);
            }
            temp = temp.next;
        }

        return pre.next;
    }
}
