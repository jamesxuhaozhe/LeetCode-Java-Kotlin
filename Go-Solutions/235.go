package main

// Problem link: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// 用bst的性质
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil || p == nil || q == nil {
		return nil
	}

	// p q 的value 都比 root 的value小，那么继续搜索 root.left
	if p.Val < root.Val && q.Val < root.Val {
		return lowestCommonAncestor(root.Left, p, q)
	}

	// p q 的value 逗比 root 的value大，那么继续搜索 root.right
	if p.Val > root.Val && q.Val > root.Val {
		return lowestCommonAncestor(root.Right, p, q)
	}

	// 如果一个比root。value 大，一个小，那么我们就找到了
	return root
}
