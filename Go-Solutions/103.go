package main

// Problem link: https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
// same as 102, just use the counter
func zigzagLevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	result := make([][]int, 0)

	queue := make([]*TreeNode, 0)
	queue = append(queue, root)
	levelCount := 0
	for len(queue) != 0 {
		size := len(queue)
		curLevel := make([]int, 0)
		for i := 0; i < size; i++ {
			node := queue[0]
			queue = queue[1:]
			curLevel = append(curLevel, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		result = append(result, curLevel)
		if levelCount % 2 != 0 {
			helpReverse(&curLevel)
		}
		levelCount += 1
	}

	return result
}

func helpReverse(arr *[]int) {
	i, j := 0, len(*arr) - 1
	for i < j {
		(*arr)[i], (*arr)[j] = (*arr)[j], (*arr)[i]
		i += 1
		j -= 1
	}
}
