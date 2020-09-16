package main

import "Go-Solutions/ds"

func invertTree(root *ds.TreeNode) *ds.TreeNode {
	if root == nil {
		return nil
	}
	invertTree(root.Left)
	invertTree(root.Right)
	root.Left, root.Right = root.Right, root.Left
	return root
}
