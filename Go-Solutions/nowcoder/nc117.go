package nowcoder

func mergeTrees117(t1 *TreeNode, t2 *TreeNode) *TreeNode {
	// write code here
	if t1 == nil && t2 == nil {
		return nil
	}

	if t1 == nil && t2 != nil {
		return t2
	}

	if t1 != nil && t2 == nil {
		return t1
	}

	return &TreeNode{Val: t1.Val + t2.Val, Left: mergeTrees117(t1.Left, t2.Left), Right: mergeTrees117(t1.Right, t2.Right)}
}
