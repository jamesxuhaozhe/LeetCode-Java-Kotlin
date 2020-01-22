package array.occurrences_after_bigram_1078

/**
 * Problem link: https://leetcode-cn.com/problems/occurrences-after-bigram/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(n)
 */
class SolutionKt {

    fun findOccurrences(text: String, first: String, second: String): Array<String> {
        val textArr = text.split(" ")
        val result = arrayListOf<String>()
        for (index in 0 until textArr.size - 2) {
            if (first == textArr[index] && second == textArr[index + 1]) {
                result.add(textArr[index + 2])
            }
        }
        return result.toTypedArray()
    }
}