package main

import "Go-Solutions/ds"

func oddEvenList(head *ds.ListNode) *ds.ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	odd := head
	even := odd.Next
	evenHead := even

	for even != nil && even.Next != nil {
		odd.Next = even.Next
		odd = odd.Next

		even.Next = odd.Next
		even = even.Next
	}
	odd.Next = evenHead
	return head
}