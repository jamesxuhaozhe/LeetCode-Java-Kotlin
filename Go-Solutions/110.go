package main

// Problem link: https://leetcode-cn.com/problems/balanced-binary-tree/
// recursion by definition
func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}

	leftHeight := getHeight110(root.Left)
	rightHeight := getHeight110(root.Right)
	return abs110(leftHeight, rightHeight) <= 1 && isBalanced(root.Left) && isBalanced(root.Right)
}

func abs110(a int, b int) int {
	if a > b {
		return a - b
	} else {
		return b - a
	}
}

func getHeight110(root *TreeNode) int {
	if root == nil {
		return 0
	}

	return max110(getHeight110(root.Left), getHeight110(root.Right)) + 1
}

func max110(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
