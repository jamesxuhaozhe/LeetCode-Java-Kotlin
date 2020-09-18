package main

// Problem link: https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
// inorder traversal, in a bst, if you do inorder traversal, the array you get is ascending
func kthSmallest(root *TreeNode, k int) int {
	if root == nil {
		return -1
	}

	arr := make([]int, 0)
	inorder230(root, &arr, k)
	return arr[k-1]
}

func inorder230(root *TreeNode, arr *[]int, k int) {
	if root == nil {
		return
	}

	inorder230(root.Left, arr, k)
	*arr = append(*arr, root.Val)
	// early return
	if len(*arr) == k {
		return
	}
	inorder230(root.Right, arr, k)
}
