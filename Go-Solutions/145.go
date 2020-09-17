package main

/**
Problem link: https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
 */
func postorderTraversal(root *TreeNode) []int {
	var result []int
	postOrder(root, &result)
	return result
}

func postOrder(root *TreeNode, result *[]int) {
	if root == nil {
		return
	}
	postOrder(root.Left, result)
	postOrder(root.Right, result)
	*result = append(*result, root.Val)
}
