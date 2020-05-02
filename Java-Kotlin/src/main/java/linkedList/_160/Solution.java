package linkedList._160;

import common.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);

        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        while (lenB < lenA) {
            headA = headA.next;
            lenA--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }


    private int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
