package linkedList.palindrome_linkedlist_234;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode dummy = head;
        while (dummy != null) {
            list.add(dummy.val);
            dummy = dummy.next;
        }

        int first = 0;
        int last = list.size() - 1;
        while (first < last) {
            if (!list.get(first).equals(list.get(last))) {
                return false;
            }
            first++;
            last--;
        }

        return true;
    }
}
