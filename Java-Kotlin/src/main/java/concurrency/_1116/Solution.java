package concurrency._1116;

import java.util.function.IntConsumer;

public class Solution {

    private int n;

    private int currentNum;

    private final Object lock = new Object();

    private volatile boolean shouldPrintZero = true;

    public Solution(int n) {
        this.n = n;
        this.currentNum = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (currentNum <= n) {
            synchronized (lock) {
                if (currentNum <= n && shouldPrintZero) {
                    printNumber.accept(0);
                    shouldPrintZero = false;
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (currentNum <= n) {
            synchronized (lock) {
                while (currentNum <= n && !shouldPrintZero && isEven(currentNum)) {
                    printNumber.accept(currentNum);
                    currentNum++;
                    shouldPrintZero = true;
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (currentNum <= n) {
            synchronized (lock) {
                while (currentNum <= n && !shouldPrintZero && !isEven(currentNum)) {
                    printNumber.accept(currentNum);
                    currentNum++;
                    shouldPrintZero = true;
                }
            }
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(51);

        Thread t1 = new Thread(() -> {
            try {
                solution.zero(value -> System.out.println(0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                solution.even(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                solution.odd(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
