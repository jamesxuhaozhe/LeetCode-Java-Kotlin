package tree._104

import common.ktdatastructure.TreeNode

class SolutionKt {

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        return Math.max(leftDepth, rightDepth) + 1
    }
}