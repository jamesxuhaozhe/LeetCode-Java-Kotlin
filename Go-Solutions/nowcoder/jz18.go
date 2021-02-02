package nowcoder

func Mirrorjz18(pRoot *TreeNode) *TreeNode {
	// write code here
	if pRoot == nil {
		return nil
	}

	pRoot.Left, pRoot.Right = pRoot.Right, pRoot.Left
	pRoot.Left = Mirrorjz18(pRoot.Left)
	pRoot.Right = Mirrorjz18(pRoot.Right)
	return pRoot
}
