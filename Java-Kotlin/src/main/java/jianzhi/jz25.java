package jianzhi;

import common.datastructure.RandomListNode;

public class jz25 {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        while (currentNode != null) {
            RandomListNode copyNode = new RandomListNode(currentNode.label);

            RandomListNode next = currentNode.next;
            currentNode.next = copyNode;
            copyNode.next = next;
            currentNode = next;
        }

        currentNode = pHead;
        while (currentNode != null) {
            RandomListNode copyNode = currentNode.next;
            copyNode.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = copyNode.next;
        }

        RandomListNode clonedHead = pHead.next;
        currentNode = pHead;
        while (currentNode != null) {
            RandomListNode clonedNode = currentNode.next;
            currentNode.next = clonedNode.next;
            clonedNode.next = clonedNode.next == null ? null : clonedNode.next.next;

            currentNode = currentNode.next;
        }

        return clonedHead;
    }
}
