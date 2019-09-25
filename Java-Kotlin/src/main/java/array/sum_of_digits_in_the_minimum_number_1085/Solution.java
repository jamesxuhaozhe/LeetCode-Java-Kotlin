package array.sum_of_digits_in_the_minimum_number_1085;

/**
 * Problem link: https://leetcode-cn.com/problems/sum-of-digits-in-the-minimum-number/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class Solution {

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
