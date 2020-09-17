package main

/**
Problem link: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
func preorderTraversal1(root *TreeNode) []int {
	var result []int
	preOrder(root, &result)
	return result
}

func preOrder(root *TreeNode, result *[]int) {
	if root == nil {
		return
	}
	*result = append(*result, root.Val)
	preOrder(root.Left, result)
	preOrder(root.Right, result)
}

// iterative
func preorderTraversal2(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	stack, result := []*TreeNode{}, []int{}
	stack = append(stack, root)
	for len(stack) != 0 {
		// stack 的实现方式
		node := stack[len(stack) - 1]
		// golang 里面把栈顶的元素出栈
		stack = stack[:len(stack) - 1]
		if node != nil {
			result = append(result, node.Val)
		}
		if node != nil && node.Right != nil {
			stack = append(stack, node.Right)
		}
		if node != nil && node.Left != nil {
			stack = append(stack, node.Left)
		}
	}
	return result
}