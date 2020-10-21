package main

import "Go-Solutions/jianzhi"

// Problem link: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
// bfs level order
func levelOrder_32_3(root *jianzhi.TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	res := make([][]int, 0)
	queue := make([]*jianzhi.TreeNode, 0)
	queue = append(queue, root)
	curLevel := 0
	for len(queue) != 0 {
		size := len(queue)
		levelSlice := make([]int, 0)
		for i := 0; i < size; i++ {
			node := queue[0]
			queue = queue[1:]
			levelSlice = append(levelSlice, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		if len(levelSlice) != 0 && curLevel%2 != 0 {
			reverse32(&levelSlice)
		}
		res = append(res, levelSlice)
		curLevel++
	}
	return res
}

func reverse32(slice *[]int) {
	i, j := 0, len(*slice)-1
	for i < j {
		(*slice)[i], (*slice)[j] = (*slice)[j], (*slice)[i]
		i++
		j--
	}
}
