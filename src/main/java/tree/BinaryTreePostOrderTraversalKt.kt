package tree

import misc.ktdatastructure.TreeNode

class BinaryTreePostOrderTraversalKt {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val result = arrayListOf<Int>()
        postOrderTraversal(root, result)
        return result
    }

    private fun postOrderTraversal(node: TreeNode?, result: MutableList<Int>) {
        if (node != null) {
            postOrderTraversal(node.left, result)
            postOrderTraversal(node.right, result)
            result.add(node.`val`)
        }
    }
}