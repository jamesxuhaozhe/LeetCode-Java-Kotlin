package newcode

func zigzagLevelOrder( root *TreeNode ) [][]int {
	// write code here
	if root == nil {
		return [][]int{}
	}

	queue := make([]*TreeNode, 0)
	queue = append(queue, root)

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
	process(res)
	return res
}

func process(res [][]int) {
	for i, v := range res {
		if i%2 == 1 {
			reverse(v)
		}
	}
}

func reverse(v []int) {
	start, end := 0, len(v)-1
	for start < end {
		v[start], v[end] = v[end], v[start]
		start++
		end--
	}
}
