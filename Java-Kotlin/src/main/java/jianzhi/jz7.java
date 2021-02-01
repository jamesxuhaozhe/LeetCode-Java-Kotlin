package jianzhi;

public class jz7 {

    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int Fibonacci_better(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
