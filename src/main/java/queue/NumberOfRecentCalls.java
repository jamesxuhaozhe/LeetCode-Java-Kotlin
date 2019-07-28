package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfRecentCalls {

    private Queue<Integer> queue;

    public NumberOfRecentCalls() {
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
