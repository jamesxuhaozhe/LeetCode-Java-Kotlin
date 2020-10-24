package linkedList._25;

import common.datastructure.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        //new Solution().reverseKGroup1(one, 3);
        exp(one);
        //one = one.next;
        //one = one.next;
        System.out.println(one.val);
    }

    private static void exp(ListNode node) {
        node = node.next;
        node = node.next;
        System.out.println(node.val);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    // classic linked list reversal
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

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //剩余数量小于k的话，则不需要反转。
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse1(head, tail);
        //下一轮的开始的地方就是tail
        head.next = reverseKGroup1(tail, k);

        return newHead;
    }

    /*
    左闭又开区间
     */
    private ListNode reverse1(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            System.out.println(head.val);
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }
}
