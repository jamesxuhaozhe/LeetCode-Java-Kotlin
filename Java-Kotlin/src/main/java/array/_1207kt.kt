package array

/**
 * Problem link: https://leetcode-cn.com/problems/unique-number-of-occurrences/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(n)
 */
class _1207kt {

    fun uniqueOccurrences(arr: IntArray): Boolean {

        val map = HashMap<Int, Int>()
        arr.forEach {
            if (map.containsKey(it)) {
                var count = map[it]!!
                count++
                map[it] = count
            } else {
                map[it] = 1
            }
        }

        val numSize = map.keys.size
        val countSize = map.values.distinct().size

        return numSize == countSize
    }
}