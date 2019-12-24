package design.design_lru_cache_146;

import java.util.Hashtable;

public class LRUCache {

    private final int capacity;

    private int size;

    private DoubleLinkedNode head = new DoubleLinkedNode();

    private DoubleLinkedNode tail = new DoubleLinkedNode();

    private final Hashtable<Integer, DoubleLinkedNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new Hashtable<>();
        this.head.next = tail;
        this.head.prev = null;
        this.tail.prev = head;
        this.tail.next = null;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            DoubleLinkedNode node = new DoubleLinkedNode();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            addNode(node);
            size++;
            if (size > capacity) {
                DoubleLinkedNode last = popTail();
                cache.remove(last.key);
                size--;
            }
        }
    }

    /**
     * Append the node right after the head
     * @param node
     */
    private void addNode(DoubleLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode popTail() {
        DoubleLinkedNode last = tail.prev;
        removeNode(last);
        return last;
    }


    private static class DoubleLinkedNode {
        private int key;
        private int value;
        private DoubleLinkedNode prev;
        private DoubleLinkedNode next;
    }
}
