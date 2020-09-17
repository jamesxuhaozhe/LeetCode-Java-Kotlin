package main

/**
 * Problem link: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
func inorderTraversal(root *TreeNode) []int {
	var result []int
	helper(root, &result)
	return result
}

func helper(root *TreeNode, result *[]int) {
	if root == nil {
		return
	}
	helper(root.Left, result)
	*result = append(*result, root.Val)
	helper(root.Right, result)
}
