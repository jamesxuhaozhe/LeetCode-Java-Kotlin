package common.datastructure;

public class LinkedListNode {
    public int value;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.value = data;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
