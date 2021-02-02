package nowcoder

func Convert(root *TreeNode) *TreeNode {
	// write code here

	if root == nil {
		return root
	}

	if root.Left == nil && root.Right == nil {
		return root
	}

	res := make([]*TreeNode, 0)
	inOrder26(root, &res)

	pre := res[0]
	dummy := pre
	for i := 1; i < len(res); i++ {
		cur := res[i]
		pre.Right = cur
		cur.Left = pre
		pre = cur
	}
	return dummy
}

func inOrder26(root *TreeNode, res *[]*TreeNode) {
	if root == nil {
		return
	}

	inOrder26(root.Left, res)
	*res = append(*res, root)
	inOrder26(root.Right, res)
}
