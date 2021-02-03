package jianzhi;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class jz29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return result;
        }

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int value : input) {
            if (pq.size() < k) {
                pq.offer(value);
            } else {
                if (pq.peek() > value) {
                    pq.poll();
                    pq.offer(value);
                }
            }
        }

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}
