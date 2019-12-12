package math.subtract_the_product_and_sum_of_digits_of_integer_1281;

/**
 * Time complexity: O(digitlen(n))
 *
 * Space complexity: O(1)
 */
public class Solution {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while(n != 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n = n / 10;
        }

        return product - sum;
    }
}
