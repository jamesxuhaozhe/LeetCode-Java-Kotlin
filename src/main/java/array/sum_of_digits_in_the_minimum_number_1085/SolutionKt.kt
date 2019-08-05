package array.sum_of_digits_in_the_minimum_number_1085

class SolutionKt {

    fun sumOfDigits(A: IntArray): Int {

        var min = Int.MAX_VALUE
        for (num in A) {
            min = Math.min(num, min)
        }

        var sum = 0
        while (min != 0) {
            val digit = min % 10
            sum += digit
            min /= 10
        }

        return if (sum % 2 == 1) 0 else 1
    }
}