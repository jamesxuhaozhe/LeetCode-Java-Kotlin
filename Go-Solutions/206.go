package main

func reverseList(head *ListNode) *ListNode {
	var newHead *ListNode = nil
	for head != nil {
		next := head.Next
		head.Next = newHead
		newHead = head
		head = next
	}
	return newHead
}
