package jianzhi;

import common.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class jz3 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        Stack<Integer> stack = new Stack<>();
        ListNode runner = listNode;
        while (runner != null) {
            stack.push(runner.val);
            runner = runner.next;
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        ListNode newHead = reverse(listNode);
        ArrayList<Integer> result = new ArrayList<>();
        while (newHead != null) {
            result.add(newHead.val);
            newHead = newHead.next;
        }
        return result;
    }

    private ListNode reverse(ListNode listNode) {
        ListNode newHead = null;
        ListNode next = null;
        ListNode runner = listNode;
        while (runner != null) {
            next = runner.next;
            runner.next = newHead;
            newHead = runner;
            runner = next;
        }
        return newHead;
    }

}
