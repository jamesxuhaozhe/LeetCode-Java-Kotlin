package system_design.design_hashmap_706;

public class MyHashMap {

    private final Node[] nodes;


    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int id = getId(key);

        Node bucket = nodes[id];
        if (bucket == null) {
            nodes[id] = new Node(-1, -1);
        }

        Node prevElement = findPrevChainingElement(nodes[id], key);
        if (prevElement.next == null) {
            prevElement.next = new Node(key, value);
        } else {
            prevElement.next.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int id = getId(key);

        Node bucket = nodes[id];
        if (bucket == null) {
            return -1;
        }

        Node prevElement = findPrevChainingElement(nodes[id], key);
        if (prevElement.next != null) {
            return prevElement.next.value;
        } else {
            return -1;
        }

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int id = getId(key);

        Node bucket = nodes[id];
        if (bucket == null) {
            return;
        }

        Node prevElement = findPrevChainingElement(nodes[id], key);
        if (prevElement.next != null) {
            prevElement.next = prevElement.next.next;
        }
    }

    private Node findPrevChainingElement(Node node, int key) {
        Node curr = node;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    private int getId(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private static class Node {
        private int key;
        private int value;
        private Node next;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
