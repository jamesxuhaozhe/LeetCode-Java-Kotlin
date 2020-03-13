package string._387

/**
 * Problem link: https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(n)
 */
class SolutionKt {

    fun firstUniqChar(s: String): Int {
        val map = HashMap<Int, Pair>()
        for (index in 0 until s.length) {
            val ch = s[index].toInt()
            if (map.containsKey(ch)) {
                map[ch]!!.freq++
            } else {
                map[ch] = Pair(1, index)
            }
        }

        var minPos = Int.MAX_VALUE
        for (entry in map.entries) {
            val pair = entry.value
            if (pair.freq == 1) {
                minPos = Math.min(minPos, pair.pos)
            }
        }

        if (minPos == Int.MAX_VALUE) {
            return -1
        }

        return minPos
    }

    class Pair(var freq: Int, var pos: Int)
}