package concurrency._1188;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Problem link: https://leetcode-cn.com/problems/design-bounded-blocking-queue/
 */
public class _1188 {

    private int maxCapacity;

    private Queue<Integer> queue;

    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();

    private Condition notEmpty = lock.newCondition();

    public _1188(int capacity) {
        this.maxCapacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == maxCapacity) {
                notFull.await();
            }

            queue.add(element);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        int result = 0;
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }

            result = queue.poll();
            notFull.signalAll();
        } finally {
            lock.unlock();
        }

        return result;
    }

    public int size() {
        return queue.size();
    }
}
