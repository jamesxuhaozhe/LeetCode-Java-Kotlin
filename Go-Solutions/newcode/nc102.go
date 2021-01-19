package newcode

func lowestCommonAncestor102(root *TreeNode, o1 int, o2 int) int {
	// write code here
	if root == nil {
		return -1
	}
	if root.Val == o1 || root.Val == o2 {
		return root.Val
	}
	left := lowestCommonAncestor102(root.Left, o1, o2)
	right := lowestCommonAncestor102(root.Right, o1, o2)

	if left != -1 && right != -1 {
		return root.Val
	}

	if left != -1 {
		return left
	}
	if right != -1 {
		return right
	}
	return -1
}
