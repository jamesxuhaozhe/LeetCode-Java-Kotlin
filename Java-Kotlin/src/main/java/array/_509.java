package array;

/**
 * Problem link: https://leetcode-cn.com/problems/fibonacci-number/
 *
 * Time complexity: O(1.6^n)
 *
 * Space Complexity: O(n)
 */
public class _509 {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }

        return fib(N - 1) + fib(N - 2);
    }
}
