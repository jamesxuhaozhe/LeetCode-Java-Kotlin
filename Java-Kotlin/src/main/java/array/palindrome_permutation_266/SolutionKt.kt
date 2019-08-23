package array.palindrome_permutation_266

/**
 * Problem link: https://leetcode-cn.com/problems/palindrome-permutation/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun canPermutePalindrome(s: String): Boolean {
        val asc = IntArray(128)
        for (index in 0 until s.length) {
            asc[s[index].toInt()]++
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