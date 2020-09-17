package main

/**
Problem link: https://leetcode-cn.com/problems/symmetric-tree/
 */
func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return isSymmetr(root.Left, root.Right)
}

func isSymmetr(left *TreeNode, right *TreeNode) bool {
	if left == nil || right == nil {
		return left == right
	}

	if left.Val != right.Val {
		return false
	}

	return isSymmetr(left.Left, right.Right) && isSymmetr(left.Right, right.Left)
}

