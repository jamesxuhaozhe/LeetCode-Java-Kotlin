package nowcoder

func solve136(pre []int, in []int) []int {
	// write code here
	if len(pre) != len(in) || len(in) == 0 || len(pre) == 0 {
		return []int{}
	}

	root := buildTree136(pre, in)
	return getRightView136(root)
}

func buildTree136(pre []int, in []int) *TreeNode {
	if len(pre) == 0 || len(in) == 0 {
		return nil
	}

	root := &TreeNode{pre[0], nil, nil}
	for i := 0; i < len(in); i++ {
		if in[i] == pre[0] {
			root.Left = buildTree136(pre[1:i+1], in[0:i])
			root.Right = buildTree136(pre[i+1:], in[i+1:])
			break
		}
	}
	return root
}

func getRightView136(root *TreeNode) []int {
	queue := make([]*TreeNode, 0)
	queue = append(queue, root)

	res := make([]int, 0)
	var tmp *TreeNode = nil
	for len(queue) != 0 {
		size := len(queue)
		for i := 0; i < size; i++ {
			tmp = queue[0]
			queue = queue[1:]
			if tmp.Left != nil {
				queue = append(queue, tmp.Left)
			}
			if tmp.Right != nil {
				queue = append(queue, tmp.Right)
			}
		}
		res = append(res, tmp.Val)
	}
	return res
}
