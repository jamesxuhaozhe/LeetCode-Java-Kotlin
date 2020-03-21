package array

/**
 * Problem link: https://leetcode-cn.com/problems/palindrome-permutation/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class _266kt {

    fun canPermutePalindrome(s: String): Boolean {
        val asc = IntArray(128)
        for (element in s) {
            asc[element.toInt()]++
        }

        var oddFreq = 0
        for (num in asc) {
            if (num % 2 == 1) {
                oddFreq++
            }
        }

        return oddFreq <= 1
    }
}