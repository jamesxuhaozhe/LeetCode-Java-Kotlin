package nowcoder;

import java.util.*;

public class nc97 {

    public String[][] topKstrings(String[] strings, int k) {
        // write code here
        if (strings == null || k > strings.length) {
            return new String[0][0];
        }

        Queue<Node> pq = new PriorityQueue<>(new Node.NodeComparator());
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        String[][] res = new String[k][2];
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            Node node = pq.poll();
            res[i][0] = node.element;
            res[i][1] = String.valueOf(node.freq);
        }

        return res;
    }

    private static class Node {
        private String element;
        private int freq;

        private Node(String element, int freq) {
            this.element = element;
            this.freq = freq;
        }

        static class NodeComparator implements Comparator<Node> {

            @Override
            public int compare(Node o1, Node o2) {
                if (o1.freq == o2.freq) {
                    return o1.element.compareTo(o2.element);
                } else {
                    return o2.freq - o1.freq;
                }
            }
        }
    }
}
