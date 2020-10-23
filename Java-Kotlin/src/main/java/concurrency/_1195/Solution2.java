package concurrency._1195;

import java.util.function.IntConsumer;

class Solution2 {
    private final Object lock = new Object();
    private int n;
    private int i;

    public Solution2(int n) {
        this.n = n;
        this.i = 1;
    }

    public static void main(String[] args) {

        Solution2 solution = new Solution2(100);

        Thread t1 = new Thread(() -> {
            try {
                solution.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-fizz");

        Thread t2 = new Thread(() -> {
            try {
                solution.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-buzz");

        Thread t3 = new Thread(() -> {
            try {
                solution.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-fizzbuzz");

        Thread t4 = new Thread(() -> {
            try {
                solution.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-number");

        t1.start();
        t4.start();


        t2.start();

        t3.start();


    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (i <= n && i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i++;
                }
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (i <= n && i % 3 != 0 && i % 5 == 0) {
                    printBuzz.run();
                    i++;
                }
            }
        }

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (i <= n && i % 3 == 0 && i % 5 == 0) {
                    printFizzBuzz.run();
                    i++;
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            synchronized (lock) {
                while (i <= n && i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    i++;
                }
            }
        }
    }
}