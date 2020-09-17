package main

// just do recursion
// Problem link: https://leetcode-cn.com/problems/same-tree/
func isSameTree(p *TreeNode, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	}

	if p == nil || q == nil {
		return false
	}

	if p.Val != q.Val {
		return false
	}

	return isSameTree(p.Right, q.Right) && isSameTree(p.Left, q.Left)
}
