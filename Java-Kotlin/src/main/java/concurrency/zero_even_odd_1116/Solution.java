package concurrency.zero_even_odd_1116;

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

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution.zero(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(0);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution.even(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution.odd(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
