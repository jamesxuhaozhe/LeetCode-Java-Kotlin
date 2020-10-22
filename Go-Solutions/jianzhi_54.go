package main

// Problem link: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
// in order traversal first
func kthLargest54(root *TreeNode, k int) int {
	arr := make([]int, 0)
	inorder54(root, &arr)
	return arr[len(arr)-k]
}

func inorder54(root *TreeNode, arr *[]int) {
	if root == nil {
		return
	}

	inorder54(root.Left, arr)

	*arr = append(*arr, root.Val)

	inorder54(root.Right, arr)
}
