package main

// Problem link: https://leetcode-cn.com/problems/binary-tree-right-side-view/
// bfs level order traversal
func rightSideView(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	queue := make([]*TreeNode, 0)
	queue = append(queue, root)

	res := make([]int, 0)

	for len(queue) != 0 {
		size := len(queue)
		for i := 0; i < size; i++ {
			node := queue[0]
			queue = queue[1:]
			// 每一层只加第一个，因为后面是先加right，后加left，所以i = 0 的时候实际上是level的最右边元素
			if i == 0 {
				res = append(res, node.Val)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
		}
	}
	return res
}
