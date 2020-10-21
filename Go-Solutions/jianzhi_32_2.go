package main


// Problem link: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
// bfs level order
func levelOrder32_2(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}

	queue := make([]*TreeNode, 0)
	queue = append(queue, root)

	res := make([][]int, 0)
	for len(queue) != 0 {
		size := len(queue)
		levelSlice := make([]int, 0)
		for i := 0; i < size; i++ {
			node := queue[0]
			queue = queue[1:]
			levelSlice = append(levelSlice, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		if len(levelSlice) != 0 {
			res = append(res, levelSlice)
		}
	}
	return res
}
