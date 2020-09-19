package jianzhi

// Problem link: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
func isBalanced_55_2(root *TreeNode) bool {
	if root == nil {
		return true
	}
	leftHeight := getHeight55_2(root.Left)
	rightHeight := getHeight55_2(root.Right)
	return abs55_2(leftHeight, rightHeight) <= 1 && isBalanced_55_2(root.Left) && isBalanced_55_2(root.Right)
}

func getHeight55_2(root *TreeNode) int {
	if root == nil {
		return 0
	}

	return max55_2(getHeight55_2(root.Left), getHeight55_2(root.Right)) + 1
}

func abs55_2(a, b int) int {
	if a > b {
		return a - b
	}
	return b - a
}

func max55_2(a, b int) int {
	if a > b {
		return a
	}
	return b
}
