package main
// Problem link : https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
// DFS
func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	result := make([][]int, 0)
	helperLevelOrder(root, &result, 0)
	return result
}

func helperLevelOrder(root *TreeNode, result *[][]int, level int) {
	if len(*result) == level {
		*result = append(*result, []int{})
	}

	(*result)[level] = append((*result)[level], root.Val)

	if root.Left != nil {
		helperLevelOrder(root.Left, result, level + 1)
	}

	if root.Right != nil {
		helperLevelOrder(root.Right, result, level + 1)
	}
}

// bfs
func levelOrder1(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	result := make([][]int, 0)

	queue := make([]*TreeNode, 0)
	queue = append(queue, root)

	for len(queue) != 0 {
		size := len(queue)
		currentLevel := make([]int, 0)
		for i := 0; i < size; i++ {
			// 相当于java里面的poll操作
			node := queue[0]
			queue = queue[1:]
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
			currentLevel = append(currentLevel, node.Val)
		}
		result = append(result, currentLevel)
	}
	return result
}
