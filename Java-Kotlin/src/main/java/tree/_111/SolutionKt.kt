package tree._111

import common.ktdatastructure.TreeNode

class SolutionKt {

    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val left = minDepth(root.left)
        val right = minDepth(root.right)

        if (left == 0) {
            return right + 1
        }

        if (right == 0) {
            return left + 1
        }

        return Math.min(left, right) + 1
    }
}