package linkedList._707;

public class MyLinkedList {

    private int size;

    private MyDoublyLinkedList headDummy;

    private MyDoublyLinkedList tailDummy;

    private static class MyDoublyLinkedList {
        private int val;

        private MyDoublyLinkedList previous;

        private MyDoublyLinkedList next;

        private MyDoublyLinkedList(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.size = 0;
        this.headDummy = new MyDoublyLinkedList(0);
        this.tailDummy = new MyDoublyLinkedList(0);
        this.headDummy.next = tailDummy;
        this.tailDummy.previous = this.headDummy;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= 0 && index < size) {
            return getNodeAtIndex(index).val;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyDoublyLinkedList preHead = headDummy.next;
        MyDoublyLinkedList currHead = new MyDoublyLinkedList(val);
        headDummy.next = currHead;
        currHead.previous = headDummy;
        currHead.next = preHead;
        preHead.previous = currHead;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyDoublyLinkedList preTail = tailDummy.previous;
        MyDoublyLinkedList currTail = new MyDoublyLinkedList(val);
        preTail.next = currTail;
        currTail.previous = preTail;
        currTail.next = tailDummy;
        tailDummy.previous = currTail;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }

        if (index == size) {
            addAtHead(val);
            return;
        }

        MyDoublyLinkedList nodeAtIndex = getNodeAtIndex(index);
        MyDoublyLinkedList preNodeAtIndex = nodeAtIndex.previous;

        MyDoublyLinkedList insertionNode = new MyDoublyLinkedList(val);
        preNodeAtIndex.next = insertionNode;
        insertionNode.previous = preNodeAtIndex;
        insertionNode.next = nodeAtIndex;
        nodeAtIndex.previous = insertionNode;
        size++;
    }

    /**
     * TODO: there is a optimization we can do here, we can fully leverage the fact that, the data we have here is
     * a doubly linked list, when having headDummy and tailDummy, it allows us to move backward as well as moving forward.
     * if the index in question is closer to headDummy, we can find it starting from the head. Otherwise, we can start from tail.
     *
     * @param index
     * @return
     */
    private MyDoublyLinkedList getNodeAtIndex(int index) {
        MyDoublyLinkedList currHead = headDummy.next;
        for (int i = 0; i < index; i++) {
            currHead = currHead.next;
        }

        return currHead;
    }


    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            MyDoublyLinkedList nodeAtIndex = getNodeAtIndex(index);
            MyDoublyLinkedList preNodeAtIndex = nodeAtIndex.previous;
            MyDoublyLinkedList nextNodeAtIndex = nodeAtIndex.next;

            preNodeAtIndex.next = nextNodeAtIndex;
            nextNodeAtIndex.previous = preNodeAtIndex;
            size--;
        }
    }
}