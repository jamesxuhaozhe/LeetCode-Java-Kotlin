package main

// https://leetcode-cn.com/problems/reverse-linked-list-ii/
func reverseBetween(head *ListNode, m int, n int) *ListNode {
	dummy := &ListNode{
		Val:  0,
		Next: head,
	}
	pre := dummy
	for i := 0; i < m - 1; i++ {
		pre = pre.Next
	}
	start := pre.Next
	end := start
	for i := 0; i < n - m; i++ {
		end = end.Next
	}
	headOfRemained := end.Next
	end.Next = nil
	pre.Next = reverse92(start)
	start.Next = headOfRemained
	return dummy.Next
}

func reverse92(head *ListNode) *ListNode {
	var newHead *ListNode = nil
	var next *ListNode = nil
	curr := head
	for curr != nil {
		next = curr.Next
		curr.Next = newHead
		newHead = curr
		curr = next
	}
	return newHead
}
