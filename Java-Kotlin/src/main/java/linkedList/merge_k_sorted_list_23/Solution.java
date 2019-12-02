package linkedList.merge_k_sorted_list_23;

import datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((Comparator<ListNode>) (o1, o2) -> o1.val - o2.val);

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
