package main

// Problem link: https://leetcode-cn.com/problems/sum-of-left-leaves/
// just recursion
func sumOfLeftLeaves(root *TreeNode) int {
	if root == nil {
		return 0
	}
	sum := 0
	helper404(root, false, &sum)
	return sum
}

func helper404(root *TreeNode, fromLeft bool, sum *int) {
	if root == nil {
		return
	}

	if root.Left == nil && root.Right == nil && fromLeft {
		*sum += root.Val
	}

	helper404(root.Left, true, sum)
	helper404(root.Right, false, sum)
}
