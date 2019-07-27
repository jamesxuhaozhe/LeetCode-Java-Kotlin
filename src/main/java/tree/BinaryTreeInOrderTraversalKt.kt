package tree

import misc.ktdatastructure.TreeNode

class BinaryTreeInOrderTraversalKt {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val result = arrayListOf<Int>()
        inOrderTraversal(root, result)
        return result
    }

    private fun inOrderTraversal(node: TreeNode?, result: MutableList<Int>) {
        if (node != null) {
            inOrderTraversal(node.left, result)
            result.add(node.`val`)
            inOrderTraversal(node.right, result)
        }
    }
}