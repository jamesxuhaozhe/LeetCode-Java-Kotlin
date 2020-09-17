package main

func levelOrderBottom(root *TreeNode) [][]int {
	result := levelOrder107(root)
	i, j := 0, len(result) - 1
	for i < j {
		result[i], result[j] = result[j], result[i]
		i += 1
		j -= 1
	}
	return result
}


func levelOrder107(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	result := make([][]int, 0)
	helperLevelOrder107(root, &result, 0)
	return result
}

func helperLevelOrder107(root *TreeNode, result *[][]int, level int) {
	if len(*result) == level {
		*result = append(*result, []int{})
	}

	(*result)[level] = append((*result)[level], root.Val)

	if root.Left != nil {
		helperLevelOrder107(root.Left, result, level + 1)
	}

	if root.Right != nil {
		helperLevelOrder107(root.Right, result, level + 1)
	}
}