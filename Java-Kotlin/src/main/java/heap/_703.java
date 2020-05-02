package heap;

import java.util.PriorityQueue;

public class _703 {

    private PriorityQueue<Integer> priorityQueue;

    private int k;

    public _703(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
