package main

/**
在二叉搜索树中，有 2 个结点的值出错了，要求修复这两个结点。
这一题按照先根遍历 1 次就可以找到这两个出问题的结点，。用中序inorder遍历二叉搜索树的时候，根结点比左子树都要大，根结点比右子树都要小。
所以左子树比根结点大的话，就是出现了乱序；根节点比右子树大的话，就是出现了乱序。
遍历过程中在左子树中如果出现了前一次遍历的结点的值大于此次根节点的值，这就出现了出错结点了，
记录下来。继续遍历直到找到第二个这样的结点。最后交换这两个结点的时候，只是交换他们的值就可以了，而不是交换这两个结点相应的指针指向。
*/
func recoverTree(root *TreeNode) {
	var prev, target1, target2 *TreeNode
	_, target1, target2 = inorderRec(root, prev, target1, target2)
	if target1 != nil && target2 != nil {
		target1.Val, target2.Val = target2.Val, target1.Val
	}
}

func inorderRec(root, prev, target1, target2 *TreeNode) (*TreeNode, *TreeNode, *TreeNode) {
	if root == nil {
		return prev, target1, target2
	}

	prev, target1, target2 = inorderRec(root.Left, prev, target1, target2)
	if prev != nil && prev.Val > root.Val {
		if target1 == nil {
			target1 = prev
		}
		target2 = root
	}
	prev = root
	prev, target1, target2 = inorderRec(root.Right, prev, target1, target2)
	return prev, target1, target2
}
