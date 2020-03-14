package sort.largest_number_179

/**
 * Problem link: https://leetcode-cn.com/problems/largest-number/
 *
 * Time complexity: O(nlogn)
 *
 * Space complexity: O(n)
 */
class _179kt {

    fun largestNumber(nums: IntArray): String {
        val numsStr = Array(nums.size) { "0" }
        nums.forEachIndexed { index, i -> numsStr[index] = i.toString() }
        numsStr.sortWith(Comparator { o1, o2 ->
            val order1 = o1 + o2
            val order2 = o2 + o1
            order2.compareTo(order1)
        })

        if (numsStr.isNotEmpty() && numsStr[0] == "0") {
            return "0"
        }

        val sb = StringBuilder()
        for (str in numsStr) {
            sb.append(str)
        }

        return sb.toString()
    }
}