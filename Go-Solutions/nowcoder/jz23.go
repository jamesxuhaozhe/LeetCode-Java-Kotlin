package nowcoder

/**
 *
 *       10
 *      /  \
 *    5    11
 *    /\    \
 *   4  9   12
 *  /
 * 3
 * 结合图中分析：
 *
 * 一棵 BST ：左孩子 < 根结点 < 右孩子
 *
 * 一棵 BST 的左子树或者右子树都是 BST
 *
 * 后序遍历是，左右根：[3, 4, 9, 5, 12, 11, 10]，结合图再从左往右分析后序序列，分析子树，可以发现：
 *
 * [3, 4, 9, 5] 10 [12, 11]
 * [3, 4] 5 [9]
 * [3] 4
 * [12] 11
 * 发现对于每一棵子树，它的根结点总是对应该子树的后序序列的最后一个数
 *
 * 那么，只需要不断地确定出左子树区间和右子树区间，并且判断：左子树区间的所有结点值 < 根结点值 < 右子树区间所有结点值，这个条件是否满足即可
 * @param sequence
 * @return
 */
func VerifySquenceOfBST(seq []int) bool {
	// write code here
	if len(seq) == 0 {
		return false
	}

	return isBST(seq, 0, len(seq)-1)
}

func isBST(seq []int, start, end int) bool {
	if start >= end {
		return true
	}

	rootVal := seq[end]
	split := start
	for ; split < end; split++ {
		if seq[split] > rootVal {
			break
		}
	}

	for i := split; i < end; i++ {
		if seq[i] < rootVal {
			return false
		}
	}

	return isBST(seq, start, split-1) && isBST(seq, split, end-1)
}
