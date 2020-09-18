package main

import "math"

// Problem link: https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
// bfs level order traversal
func largestValues(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	res := make([]int, 0)
	res = append(res, root.Val)

	queue := make([]*TreeNode, 0)
	queue = append(queue, root)

	for len(queue) != 0 {
		size := len(queue)
		max := math.Inf(-1)
		for i := 0; i < size; i++ {
			node := queue[0]
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
				max = math.Max(max, float64(node.Left.Val))
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
				max = math.Max(max, float64(node.Right.Val))
			}
		}
		if max != math.Inf(-1) {
			res = append(res, int(max))
		}
	}
	return res
}
