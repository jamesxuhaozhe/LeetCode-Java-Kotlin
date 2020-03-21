package array

/**
 * Problem link: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class _26kt {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var i = 0
        for (j in 1 until nums.size) {
            if (nums[j] != nums[i]) {
                i++
                nums[i] = nums[j]
            }
        }

        return i + 1
    }
}