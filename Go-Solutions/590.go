package main

type Node590 struct {
	Val      int
	Children []*Node
}

func postorder590(root *Node590) []int {
	if root == nil {
		return []int{}
	}

	res := make([]int, 0)
	postOrder590(root, &res)
	return res
}

func postOrder590(root *Node590, res *[]int) {
	if root == nil {
		return
	}
	for _, n := range root.Children {
		postOrder(n, res)
	}
	*res = append(*res, root.Val)
}
