package concurrency.print_foo_bar_alter_1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Problem link: https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class FooBar {

    private int n;

    private Lock lock = new ReentrantLock();

    private Condition fooTurn = lock.newCondition();

    private Condition barTurn = lock.newCondition();

    private volatile boolean isFooTurn = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            lock.lock();
            try {
                while (!isFooTurn) {
                    fooTurn.await();
                }
                printFoo.run();
                isFooTurn = false;
                barTurn.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            lock.lock();
            try {
                while (isFooTurn) {
                    barTurn.await();
                }
                printBar.run();
                isFooTurn = true;
                fooTurn.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
