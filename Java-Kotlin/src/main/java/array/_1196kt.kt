package array

/**
 * Problem link: https://leetcode-cn.com/problems/how-many-apples-can-you-put-into-the-basket/
 *
 * Time complexity: O(nlogn)
 *
 * Space complexity: O(n)
 */
class _1196kt {

    companion object {
        const val MAX = 5000
    }

    fun maxNumberOfApples(arr: IntArray): Int {
        arr.sort()

        var currentSum = 0
        arr.forEachIndexed { index, i ->
            currentSum += i
            if (currentSum > MAX) {
                return index
            }
        }

        return arr.size
    }
}