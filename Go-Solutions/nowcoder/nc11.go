package nowcoder

func sortedArrayToBST( num []int ) *TreeNode {
	// write code here
	if len(num) == 0 {
		return nil
	}
	mid := num[len(num)/2]
	return &TreeNode{
		Val: mid,
		Left: sortedArrayToBST(num[:len(num)/2]),
		Right: sortedArrayToBST(num[len(num)/2+1:]),
	}
}
