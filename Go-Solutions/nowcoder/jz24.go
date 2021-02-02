package nowcoder

func FindPath(root *TreeNode, sum int) [][]int {
	// write code here
	if root == nil {
		return [][]int{}
	}
	res := make([][]int, 0)
	list := make([]int, 0)
	dfs(root, &res, &list, sum)
	return res
}

func dfs(node *TreeNode, res *[][]int, list *[]int, leftToSum int) {
	if node == nil {
		return
	}

	if node.Val > leftToSum {
		return
	}

	*list = append(*list, node.Val)
	if node.Val == leftToSum && node.Left == nil && node.Right == nil {
		listToAdd := make([]int, len(*list))
		for i := 0; i < len(*list); i++ {
			listToAdd[i] = (*list)[i]
		}
		*res = append(*res, listToAdd)
	} else {
		dfs(node.Left, res, list, leftToSum-node.Val)
		dfs(node.Right, res, list, leftToSum-node.Val)
	}
	*list = (*list)[:len(*list)-1]
}
