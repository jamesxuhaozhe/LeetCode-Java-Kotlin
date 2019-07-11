package misc;

public class CreateALinkedList {

    private static class Node {
        Node next = null;
        int data;

        Node(int d) {
            this.data = d;
        }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }
}
