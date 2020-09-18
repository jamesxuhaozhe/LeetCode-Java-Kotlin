package main

// Problem link: https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
// level order traversal bfs
func averageOfLevels(root *TreeNode) []float64 {
	if root == nil {
		return nil
	}
	res := make([]float64, 0)
	res = append(res, float64(root.Val))
	queue := make([]*TreeNode, 0)
	queue = append(queue, root)
	for len(queue) != 0 {
		size := len(queue)
		nextLevelCount := 0
		var nextLevelSum float64
		for i := 0; i < size; i++ {
			node := queue[0]
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
				nextLevelSum += float64(node.Left.Val)
				nextLevelCount++
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
				nextLevelSum += float64(node.Right.Val)
				nextLevelCount++
			}
		}
		if nextLevelCount > 0 {
			res = append(res, nextLevelSum / float64(nextLevelCount))
		}
	}
	return res
}
