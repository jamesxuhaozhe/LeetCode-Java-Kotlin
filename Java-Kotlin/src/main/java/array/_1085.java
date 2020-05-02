package array;

/**
 * Problem link: https://leetcode-cn.com/problems/sum-of-digits-in-the-minimum-number/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class _1085 {

    public int sumOfDigits(int[] A) {

        int min = Integer.MAX_VALUE;
        for (int num : A) {
            min = Math.min(num, min);
        }

        int sum = 0;
        while (min != 0) {
            int digit = min % 10;
            sum += digit;
            min /= 10;
        }

        return sum % 2 == 1 ? 0 : 1;
    }
}
