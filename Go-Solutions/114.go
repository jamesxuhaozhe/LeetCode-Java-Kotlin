package main

func flatten(root *TreeNode)  {
	if root == nil {
		return
	}
	nodes := make([]*TreeNode, 0)
	inOrderTraverse(root, &nodes)

	for i := 1; i < len(nodes); i++ {
		prev, cur := nodes[i-1], nodes[i]
		prev.Left, prev.Right = nil, cur
	}
}

func inOrderTraverse(root *TreeNode, nodes *[]*TreeNode) {
	if root == nil {
		return
	}
	*nodes = append(*nodes, root)
	inOrderTraverse(root.Left, nodes)
	inOrderTraverse(root.Right, nodes)
}
