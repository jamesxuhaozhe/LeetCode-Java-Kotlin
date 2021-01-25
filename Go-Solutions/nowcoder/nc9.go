package nowcoder

// TODO use java
func hasPathSum( root *TreeNode ,  sum int ) bool {
	// write code here
	if root == nil {
		return false
	}
	if root.Left == nil && root.Right == nil {
		if root.Val == sum {
			return true
		}
	}
	return hasPathSum(root.Left, sum-root.Val) || hasPathSum(root.Right, sum-root.Val)
}
