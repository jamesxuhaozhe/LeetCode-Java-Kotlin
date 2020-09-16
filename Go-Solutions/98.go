package main

import (
	"Go-Solutions/ds"
)

// Problem link:https://leetcode-cn.com/problems/validate-binary-search-tree/
// 先inorder 遍历，如果是valid bst，那么数组里面的元素一定是严格升序的
func isValidBST(root *ds.TreeNode) bool {
	var arr []int
	inorder(root, &arr)
	for i := 1; i < len(arr); i++ {
		if arr[i - 1] >= arr[i] {
			return false
		}
	}
	return true
}

func inorder(root *ds.TreeNode, result *[]int) {
	if root == nil {
		return
	}

	inorder(root.Left, result)
	*result = append(*result, root.Val)
	inorder(root.Right, result)
}