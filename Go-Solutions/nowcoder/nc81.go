package nowcoder

func KthNode(pRoot *TreeNode, k int) *TreeNode {
	// write code here
	if pRoot == nil {
		return nil
	}

	values := make([]*TreeNode, 0)
	inOrderTraverse(pRoot, &values)

	size := len(values)
	if k < 1 || k > size {
		return nil
	}

	return values[k-1]
}

func inOrderTraverse(root *TreeNode, values *[]*TreeNode) {
	if root == nil {
		return
	}
	inOrderTraverse(root.Left, values)
	*values = append(*values, root)
	inOrderTraverse(root.Right, values)
}
