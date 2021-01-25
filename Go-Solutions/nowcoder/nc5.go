package nowcoder

// todo use java
func sumNumbers5(root *TreeNode) int {
	// write code here
	if root == nil {
		return 0
	}

	return sumNum5(root, root.Val)
}

func sumNum5(root *TreeNode, sum int) int {
	if root.Left == nil && root.Right == nil {
		return sum
	}
	result := 0
	if root.Left != nil {
		result += sumNum5(root.Left, sum*10+root.Left.Val)
	}
	if root.Right != nil {
		result += sumNum5(root.Right, sum*10+root.Right.Val)
	}
	return result
}
