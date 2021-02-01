package nowcoder

func reConstructBinaryTreejz4(pre []int, in []int) *TreeNode {
	// write code here

	if pre == nil || len(pre) == 0 || in == nil || len(in) == 0 || len(pre) != len(in) {
		return nil
	}

	root := &TreeNode{pre[0], nil, nil}
	for i := 0; i < len(in); i++ {
		if in[i] == pre[0] {
			root.Left = reConstructBinaryTree(pre[1:i+1], in[0:i])
			root.Right = reConstructBinaryTree(pre[i+1:], in[i+1:])
			break
		}
	}
	return root
}
