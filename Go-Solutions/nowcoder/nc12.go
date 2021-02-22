package nowcoder

/**
 * 1. 分析
 * 根据中序遍历和前序遍历可以确定二叉树，具体过程为：
 *
 * 根据前序序列第一个结点确定根结点
 * 根据根结点在中序序列中的位置分割出左右两个子序列
 * 对左子树和右子树分别递归使用同样的方法继续分解
 * 例如：
 * 前序序列{1,2,4,7,3,5,6,8} = pre
 * 中序序列{4,7,2,1,5,3,8,6} = in
 *
 * 根据当前前序序列的第一个结点确定根结点，为 1
 * 找到 1 在中序遍历序列中的位置，为 in[3]
 * 切割左右子树，则 in[3] 前面的为左子树， in[3] 后面的为右子树
 * 则切割后的左子树前序序列为：{2,4,7}，切割后的左子树中序序列为：{4,7,2}；切割后的右子树前序序列为：{3,5,6,8}，切割后的右子树中序序列为：{5,3,8,6}
 * 对子树分别使用同样的方法分解
 */
func reConstructBinaryTree(pre []int, vin []int) *TreeNode {
	// write code here
	if pre == nil || len(pre) == 0 || vin == nil || len(vin) == 0 {
		return nil
	}

	root := &TreeNode{Val: pre[0], Left: nil, Right: nil,}
	for i := 0; i < len(vin); i++ {
		if vin[i] == pre[0] {
			root.Left = reConstructBinaryTree(pre[1:i+1], vin[0:i])
			root.Right = reConstructBinaryTree(pre[i+1:], vin[i+1:])
		}
	}
	return root
}
