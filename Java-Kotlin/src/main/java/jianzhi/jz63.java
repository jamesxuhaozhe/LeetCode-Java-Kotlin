package jianzhi;

import java.util.PriorityQueue;
import java.util.Queue;

public class jz63 {


    private Queue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);

    private Queue<Integer> right = new PriorityQueue<>();

    private int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            left.offer(num);
            right.offer(left.poll());
        } else {
            right.offer(num);
            left.offer(right.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) right.peek();
        }
    }
}
