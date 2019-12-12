package math.subtract_the_product_and_sum_of_digits_of_integer_1281

/**
 * Time complexity: O(digitlen(n))
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun subtractProductAndSum(n: Int): Int {
        var sum = 0
        var product = 1
        var n = n
        while(n != 0) {
            val digit = n % 10
            sum += digit
            product *= digit
            n /= 10
        }

        return product - sum
    }
}