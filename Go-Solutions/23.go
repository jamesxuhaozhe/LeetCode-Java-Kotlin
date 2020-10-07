package main

// like enhanced version of problem 21, essentially merge sort, again, merge two sorted list is quite important
func mergeKLists(lists []*ListNode) *ListNode {
	length := len(lists)
	if length < 1 {
		return nil
	}
	if length == 1 {
		return lists[0]
	}

	mid := length / 2
	left := mergeKLists(lists[:mid])
	right := mergeKLists(lists[mid:])
	return mergeTwoSortedLists23(left, right)
}

func mergeTwoSortedLists23(left *ListNode, right *ListNode) *ListNode {
	dummy := &ListNode{
		Val:  -1,
		Next: nil,
	}
	tmp := dummy
	for left != nil && right != nil {
		if left.Val < right.Val {
			tmp.Next = left
			left = left.Next
		} else {
			tmp.Next = right
			right = right.Next
		}
		tmp = tmp.Next
	}
	if left != nil {
		tmp.Next = left
	}
	if right != nil {
		tmp.Next = right
	}
	return dummy.Next
}
