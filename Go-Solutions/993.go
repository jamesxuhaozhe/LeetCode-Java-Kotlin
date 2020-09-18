package main

// Problem link： https://leetcode-cn.com/problems/cousins-in-binary-tree/

// this is a recursion solution
func isCousins(root *TreeNode, x int, y int) bool {
	if root == nil {
		return false
	}

	xLevel, yLevel := getLevel993(root, x, 1), getLevel993(root, y, 1)
	if xLevel != yLevel {
		return false
	}

	return !hasSameParent993(root, x, y)

}

// check if the values have the same parent
func hasSameParent993(root *TreeNode, x int, y int) bool {
	if root == nil {
		return false
	}

	if root.Left != nil && root.Right != nil {
		if (root.Left.Val == x && root.Right.Val == y) || (root.Left.Val == y && root.Right.Val == x) {
			return true
		}
	}

	return hasSameParent993(root.Left, x, y) || hasSameParent993(root.Right, x, y)
}

// get the level of the given value
func getLevel993(root *TreeNode, val int, level int) int {
	if root == nil {
		return 0
	}

	if root.Val == val {
		return level
	}

	leftLevel, rightLevel := getLevel993(root.Left, val, level+1), getLevel993(root.Right, val, level+1)
	if leftLevel == 0 {
		return rightLevel
	}
	return leftLevel
}

// dfs
func isCousins1(root *TreeNode, x int, y int) bool {
	if root == nil {
		return false
	}
	var xDepth, yDepth, xParent, yParent int
	dfs993(root, x, 0, -1, &xParent, &xDepth)
	dfs993(root, y, 0, -1, &yParent, &yDepth)
	return xDepth > 1 && xDepth == yDepth && xParent != yParent
}

func dfs993(root *TreeNode, val int, depth int, last int, parent *int, depthRes *int) {
	if root == nil {
		return
	}

	if root.Val == val {
		*depthRes = depth
		*parent = last
	}
	depth++
	dfs993(root.Left, val, depth, root.Val, parent, depthRes)
	dfs993(root.Right, val, depth, root.Val, parent, depthRes)
}

type node993 struct {
	parent int
	depth  int
}

// bfs, just like level order bfs traversal, but need to add one more data structure
func isCousins2(root *TreeNode, x int, y int) bool {
	if root == nil {
		return false
	}

	visitedNodes := make(map[int]node993, 100)
	visitedNodes[root.Val] = node993{
		parent: -1,
		depth:  0,
	}

	queue := make([]*TreeNode, 0)
	queue = append(queue, root)
	level := 0
	for len(queue) != 0 {
		size := len(queue)
		for i := 0; i < size; i++ {
			n := queue[0]
			queue = queue[1:]
			if n.Left != nil {
				queue = append(queue, n.Left)
				visitedNodes[n.Left.Val] = node993{
					parent: n.Val,
					depth:  level + 1,
				}
			}
			if n.Right != nil {
				queue = append(queue, n.Right)
				visitedNodes[n.Right.Val] = node993{
					parent: n.Val,
					depth:  level + 1,
				}
			}
		}
		level++
	}

	xNode, yNode := visitedNodes[x], visitedNodes[y]
	return xNode.parent != yNode.parent && xNode.depth > 1 && xNode.depth == yNode.depth
}
