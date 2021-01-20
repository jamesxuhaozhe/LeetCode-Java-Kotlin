package nowcoder

func Print80(pRoot *TreeNode) [][]int {
	// write code here
	if pRoot == nil {
		return [][]int{}
	}

	queue := make([]*TreeNode, 0)
	queue = append(queue, pRoot)

	res := make([][]int, 0)
	for len(queue) != 0 {
		levelSize := len(queue)
		level := make([]int, 0)
		for i := 0; i < levelSize; i++ {
			node := queue[0]
			queue = queue[1:]
			level = append(level, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		res = append(res, level)
	}
	return res
}
