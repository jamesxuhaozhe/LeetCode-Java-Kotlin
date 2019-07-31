package tree

import common.ktdatastructure.TreeNode

class BinaryTreePreOrderTraversalKt {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val result = arrayListOf<Int>()
        preOrderTraversal(root, result)
        return result
    }

    private fun preOrderTraversal(node: TreeNode?, result: MutableList<Int>) {
        if (node != null) {
            result.add(node.`val`)
            preOrderTraversal(node.left, result)
            preOrderTraversal(node.right, result)
        }
    }
}