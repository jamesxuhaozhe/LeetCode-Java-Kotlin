package string.remove_vowels_from_string_1119

/**
 * Problem link: https://leetcode-cn.com/problems/remove-vowels-from-a-string/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(n)
 */
class RemoveVowelsFromStringKt {

    fun removeVowels(S: String): String {
        val chs = S.toCharArray()
        val sb = StringBuilder()
        for (ch in chs) {
            if (!isVowels(ch)) {
                sb.append(ch)
            }
        }
        return sb.toString()
    }

    private fun isVowels(ch: Char): Boolean {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
    }
}