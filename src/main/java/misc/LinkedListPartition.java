package misc;

import common.datastructure.LinkedListNode;

public class LinkedListPartition {

    LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            //This is to save the next element, which is a common practice in linkedlist problem
            LinkedListNode next = node.next;
            if (node.value < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(3);
        LinkedListNode node2 = new LinkedListNode(5);
        LinkedListNode node3 = new LinkedListNode(8);
        LinkedListNode node4 = new LinkedListNode(5);
        LinkedListNode node5 = new LinkedListNode(10);
        LinkedListNode node6 = new LinkedListNode(2);
        LinkedListNode node7 = new LinkedListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        System.out.println(new LinkedListPartition().partition(node1, 5));

    }
}
