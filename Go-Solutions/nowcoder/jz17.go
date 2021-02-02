package nowcoder

/**
思路：
第一步：在树A中找到和树B的节点一样的节点R
第二部：判断树A以R为根节点的子树是不是包含树B一样的结构

摘自书上，思路很清晰了，做一个说明：
第一步其实是对树A进行遍历，遍历的话，你可以选深度遍历，也可以选层次遍历，都ok
// 刚开始写的层次遍历，感觉代码稍微有点长，就换成了深度遍历
*/
func HasSubtreejz17(pRoot1 *TreeNode, pRoot2 *TreeNode) bool {
	// write code here
	if pRoot1 == nil || pRoot2 == nil {
		return false
	}

	return HasSubtreejz17(pRoot1.Left, pRoot2) || HasSubtreejz17(pRoot1.Right, pRoot2) || isSubtreejz17(pRoot1, pRoot2)
}

func isSubtreejz17(rootA, rootB *TreeNode) bool {
	if rootB == nil {
		return true
	}
	if rootA == nil {
		return false
	}
	if rootA.Val != rootB.Val {
		return false
	}

	return isSubtreejz17(rootA.Left, rootB.Left) && isSubtreejz17(rootA.Right, rootB.Right)
}
