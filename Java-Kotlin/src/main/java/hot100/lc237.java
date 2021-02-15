package hot100;

import common.datastructure.ListNode;

public class lc237 {

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        ListNode nextNextNode = node.next.next;
        node.val = node.next.val;
        node.next = nextNextNode;
    }
}
