package array.fibonacci_number_509

/**
 * Problem link: https://leetcode-cn.com/problems/fibonacci-number/
 *
 * Time complexity: O(1.6^n)
 *
 * Space Complexity: O(n)
 */
class FibonacciNumberKt {

    fun fib(N: Int): Int {
        if (N == 0) {
            return 0
        }

        if (N == 1) {
            return 1
        }

        return fib(N - 1) + fib(N - 2)
    }
}