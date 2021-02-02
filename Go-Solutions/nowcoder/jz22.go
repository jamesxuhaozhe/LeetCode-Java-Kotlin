package nowcoder

func PrintFromTopToBottom(root *TreeNode) []int {
	// write code here
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
			res = append(res, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
	}
	return res
}
