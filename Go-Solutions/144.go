package main

import "Go-Solutions/ds"

/**
Problem link: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
func preorderTraversal(root *ds.TreeNode) []int {
	var result []int
	preOrder(root, &result)
	return result
}

func preOrder(root *ds.TreeNode, result *[]int) {
	if root == nil {
		return
	}
	*result = append(*result, root.Val)
	preOrder(root.Left, result)
	preOrder(root.Right, result)
}
