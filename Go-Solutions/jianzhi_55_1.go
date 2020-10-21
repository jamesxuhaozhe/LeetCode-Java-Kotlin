package main


// Problem link: https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
// nothing but standard depth of binary tree
func maxDepth55_1(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return max55_1(maxDepth55_1(root.Left), maxDepth55_1(root.Right)) + 1
}

func max55_1(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
