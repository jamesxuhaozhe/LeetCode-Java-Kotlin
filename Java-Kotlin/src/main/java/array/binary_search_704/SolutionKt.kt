package array.binary_search_704

/**
 * Problem link: https://leetcode-cn.com/problems/binary-search/
 *
 * Time complexity: O(logn)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return -1
        }

        var start = 0
        var end = nums.size - 1
        while (start <= end) {
            val mid = (start + end) / 2
            if (target == nums[mid]) {
                return mid
            }
            if (target < nums[mid]) {
                end = mid - 1
            }
            if (target > nums[mid]) {
                start = mid + 1
            }
        }

        return -1
    }
}