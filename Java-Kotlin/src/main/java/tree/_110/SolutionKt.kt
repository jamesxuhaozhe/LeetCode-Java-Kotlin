package tree._110

import common.ktdatastructure.TreeNode

class SolutionKt {
    fun isBalanced(root: TreeNode?): Boolean {
        return checkHeight(root) != Int.MIN_VALUE
    }

    private fun checkHeight(node: TreeNode?): Int {
        if (node == null) {
            return -1
        }

        val leftHeight = checkHeight(node.left)
        if (leftHeight == Int.MIN_VALUE) {
            return Int.MIN_VALUE
        }

        val rightHeight = checkHeight(node.right)
        if (rightHeight == Int.MIN_VALUE) {
            return Int.MIN_VALUE
        }

        return if (Math.abs(leftHeight - rightHeight) > 1) {
            Int.MIN_VALUE
        } else {
            Math.max(leftHeight, rightHeight) + 1
        }
    }
}