package concurrency._1114;

import java.util.concurrent.CountDownLatch;

public class Solution {

    class Foo {

        private CountDownLatch second;

        private CountDownLatch third;

        public Foo() {
            second = new CountDownLatch(1);
            third = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            second.await();
            printSecond.run();
            third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            third.await();
            printThird.run();
        }
    }
}
