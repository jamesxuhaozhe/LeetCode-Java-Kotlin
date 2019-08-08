package tree

import common.ktdatastructure.TreeNode

class ConvertSortedArrayToBSTKt {

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) {
            return null
        }
        return createBST(nums, 0, nums.size - 1)
    }

    private fun createBST(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (end < start) {
            return null
        }
        val mid = (start + end) / 2
        val node = TreeNode(nums[mid])
        node.left = createBST(nums, start, mid - 1)
        node.right = createBST(nums, mid + 1, end)
        return node
    }
}