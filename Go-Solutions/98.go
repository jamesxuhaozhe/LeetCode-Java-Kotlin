package main

import (
	"Go-Solutions/ds"
	"math"
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

// solution that goes by definition
func isValidBST1(root *ds.TreeNode) bool {
	return isValid(root, math.Inf(-1), math.Inf(1))
}

func isValid(root *ds.TreeNode, min float64, max float64) bool {
	if root == nil {
		return true
	}

	v := float64(root.Val)
	return v < max && v > min && isValid(root.Left, min, v) && isValid(root.Right, v, max)
}
