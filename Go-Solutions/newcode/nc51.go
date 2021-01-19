package newcode

func mergeKLists(lists []*ListNode) *ListNode {
	// write code here
	if lists == nil {
		return nil
	}
	if len(lists) == 1 {
		return lists[0]
	}
	mid := len(lists) / 2
	left := mergeKLists(lists[:mid])
	right := mergeKLists(lists[mid:])
	return mergeTwoSortedList51(left, right)
}

func mergeTwoSortedList51(left, right *ListNode) *ListNode {
	if left == nil && right == nil {
		return nil
	}
	if left == nil {
		return right
	}
	if right == nil {
		return left
	}
	dummy := &ListNode{Val: -1, Next: nil,}
	runner := dummy
	for left != nil && right != nil {
		if left.Val < right.Val {
			runner.Next = left
			left = left.Next
		} else {
			runner.Next = right
			right = right.Next
		}
		runner = runner.Next
	}
	if left != nil {
		runner.Next = left
	}
	if right != nil {
		runner.Next = right
	}
	return dummy.Next
}
