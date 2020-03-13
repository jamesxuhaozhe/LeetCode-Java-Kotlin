package queue._933;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    private Queue<Integer> queue;

    public Solution() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < (t - 3000)) {
            queue.remove();
        }
        return queue.size();
    }
}
