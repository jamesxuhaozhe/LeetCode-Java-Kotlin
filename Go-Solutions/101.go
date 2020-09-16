package main

import "Go-Solutions/ds"

/**
Problem link: https://leetcode-cn.com/problems/symmetric-tree/
 */
func isSymmetric(root *ds.TreeNode) bool {
	if root == nil {
		return true
	}
	return isSymmetr(root.Left, root.Right)
}

func isSymmetr(left *ds.TreeNode, right *ds.TreeNode) bool {
	if left == nil || right == nil {
		return left == right
	}

	if left.Val != right.Val {
		return false
	}

	return isSymmetr(left.Left, right.Right) && isSymmetr(left.Right, right.Left)
}

