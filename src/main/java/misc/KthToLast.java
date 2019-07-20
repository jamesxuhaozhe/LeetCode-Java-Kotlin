package misc;

import misc.datastructure.LinkedListNode;

public class KthToLast {

    class Index {
        public int value = 0;
    }

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        Index index = new Index();
        return kthToLast(head, k, index);
    }

    private LinkedListNode kthToLast(LinkedListNode head, int k, Index index) {
        if (head == null) {
            return null;
        }
        LinkedListNode node = kthToLast(head.next, k, index);
        index.value++;
        if (index.value == k) {
            return head;
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode node1 = new LinkedListNode(2);
        LinkedListNode node2 = new LinkedListNode(3);
        LinkedListNode node3 = new LinkedListNode(4);
        LinkedListNode node4 = new LinkedListNode(5);
        LinkedListNode node5 = new LinkedListNode(6);
        LinkedListNode node6 = new LinkedListNode(7);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        LinkedListNode kthNode = new KthToLast().kthToLast(head, 1);
        System.out.println(kthNode);
    }
}
