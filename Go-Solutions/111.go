package main

// Problem link: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
// recursion by definition
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	if root.Left == nil {
		return minDepth(root.Right) + 1
	}

	if root.Right == nil {
		return minDepth(root.Left) + 1
	}

	return min111(minDepth(root.Left), minDepth(root.Right)) + 1
}

func min111(a int, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}
