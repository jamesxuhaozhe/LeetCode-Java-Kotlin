package concurrency._1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3(1000);

        Thread t1 = new Thread(() -> {
            try {
                solution.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                solution.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                solution.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                solution.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t4.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();


    }

    private int n;

    private final Semaphore fizzSem = new Semaphore(0);

    private final Semaphore buzzSem = new Semaphore(0);

    private final Semaphore fizzBuzzSem = new Semaphore(0);

    private final Semaphore numberSem = new Semaphore(1);


    public Solution3(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {

            if (isFizzOK(i)) {
                fizzSem.acquire();
                printFizz.run();
                numberSem.release();
            }


        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {

            if (isBuzzOK(i)) {
                buzzSem.acquire();
                printBuzz.run();
                numberSem.release();
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {

            if (isFizzBuzzOK(i)) {
                fizzBuzzSem.acquire();
                printFizzBuzz.run();
                numberSem.release();
            }

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numberSem.acquire();
            if (isNumberOK(i)) {
                printNumber.accept(i);
                numberSem.release();
            }

            if (isFizzOK(i)) {
                fizzSem.release();
            }

            if (isBuzzOK(i)) {
                buzzSem.release();
            }

            if (isFizzBuzzOK(i)) {
                fizzBuzzSem.release();
            }
        }
    }

    private static boolean isFizzOK(int number) {
        return number % 3 == 0 && number % 5 != 0;
    }

    private static boolean isBuzzOK(int number) {
        return number % 3 != 0 && number % 5 == 0;
    }

    private static boolean isFizzBuzzOK(int number) {
        return number % 3 == 0 && number % 5 == 0;
    }

    private static boolean isNumberOK(int number) {
        return number % 3 != 0 && number % 5 != 0;
    }
}
