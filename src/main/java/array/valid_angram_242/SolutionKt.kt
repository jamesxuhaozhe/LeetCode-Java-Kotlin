package array.valid_angram_242

/**
 * Problem link: https://leetcode-cn.com/problems/valid-anagram/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun isAnagram(s: String, t: String): Boolean {
        val alpha = IntArray(26)
        val sArr = s.toCharArray()
        for (index in sArr.indices) {
            val id = sArr[index] - 'a'
            alpha[id]++
        }

        val tArr = t.toCharArray()
        for (index in tArr.indices) {
            val id = tArr[index] - 'a'
            alpha[id]--
            if (alpha[id] < 0) {
                return false
            }
        }

        return alpha.sum() == 0
    }
}