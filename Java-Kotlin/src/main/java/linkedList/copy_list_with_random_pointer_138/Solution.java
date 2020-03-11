package linkedList.copy_list_with_random_pointer_138;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem link: https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * Time complexity: O(n), n is the length of the list
 *
 * Space complexity: O(n), n is the length of the list
 */
public class Solution {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;

        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
