package tree

import misc.ktdatastructure.TreeNode

class MaxDepthTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        return Math.max(leftDepth, rightDepth) + 1
    }
}