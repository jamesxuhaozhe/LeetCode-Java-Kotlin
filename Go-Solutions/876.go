package main

//https://leetcode-cn.com/problems/middle-of-the-linked-list/
// very classic
func middleNode(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	length := 0
	cur := head
	for cur != nil {
		length++
		cur = cur.Next
	}

	slow, fast := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	if length%2 == 1 {
		return slow
	}
	return slow.Next
}
