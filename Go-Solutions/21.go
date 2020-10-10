package main

// Problem link: https://leetcode-cn.com/problems/merge-two-sorted-lists/
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	if l1.Val < l2.Val {
		l1.Next = mergeTwoLists(l1.Next, l2)
		return l1
	}
	l2.Next = mergeTwoLists(l1, l2.Next)
	return l2
}

func mergeTwoLists_2(left *ListNode, right *ListNode) *ListNode {
	dummy := &ListNode{
		Val:  -1,
		Next: nil,
	}
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
