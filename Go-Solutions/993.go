package main

// Problem link： https://leetcode-cn.com/problems/cousins-in-binary-tree/

// this is a recursion solution
func isCousins(root *TreeNode, x int, y int) bool {
	if root == nil {
		return false
	}

	xLevel, yLevel := getLevel993(root, x, 1), getLevel993(root, y, 1)
	if xLevel != yLevel {
		return false
	}

	return !hasSameParent993(root, x, y)

}

// check if the values have the same parent
func hasSameParent993(root *TreeNode, x int, y int) bool {
	if root == nil {
		return false
	}

	if root.Left != nil && root.Right != nil {
		if (root.Left.Val == x && root.Right.Val == y) || (root.Left.Val == y && root.Right.Val == x) {
			return true
		}
	}

	return hasSameParent993(root.Left, x, y) || hasSameParent993(root.Right, x, y)
}

// get the level of the given value
func getLevel993(root *TreeNode, val int, level int) int {
	if root == nil {
		return 0
	}

	if root.Val == val {
		return level
	}

	leftLevel, rightLevel := getLevel993(root.Left, val, level + 1), getLevel993(root.Right, val, level + 1)
	if leftLevel == 0 {
		return rightLevel
	}
	return leftLevel
}
