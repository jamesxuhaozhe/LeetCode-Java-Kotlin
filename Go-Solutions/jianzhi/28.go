package jianzhi

// Problem link: https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
func isSymmetric28(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return isSymmetric28Helper(root.Left, root.Right)
}

func isSymmetric28Helper(left *TreeNode, right *TreeNode) bool {
	if left == nil || right == nil {
		return left == right
	}

	if left.Val != right.Val {
		return false
	}

	return isSymmetric28Helper(left.Left, right.Right) && isSymmetric28Helper(left.Right, right.Left)
}
