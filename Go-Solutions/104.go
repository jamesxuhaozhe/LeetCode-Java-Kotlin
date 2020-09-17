package main

// Problem link: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	return findMax(maxDepth(root.Left), maxDepth(root.Right)) + 1
}

func findMax(num1 int, num2 int) int {
	if num1 > num2 {
		return num1
	} else {
		return num2
	}
}
