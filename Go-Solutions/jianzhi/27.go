package jianzhi

// Problem link: https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
// just recursive
func mirrorTree(root *TreeNode) *TreeNode {
	if root == nil {
		return root
	}

	root.Left, root.Right = mirrorTree(root.Right), mirrorTree(root.Left)
	return root
}
