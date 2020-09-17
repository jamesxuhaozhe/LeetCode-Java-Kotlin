package main

func reverseBetween(head *ListNode, m int, n int) *ListNode {
	dummy := &ListNode{
		Val:  0,
		Next: head,
	}
	pre := dummy
	for i := 0; i < m-1; i++ {
		pre = pre.Next
	}
	start := pre.Next
	end := start
	for i := 0; i < n-m; i++ {
		end = end.Next
	}
	headOfRemained := end.Next
	end.Next = nil
	pre.Next = reverseList(start)
	start.Next = headOfRemained
	return dummy.Next
}

func reverseList(head *ListNode) *ListNode {
	var pre *ListNode = nil
	curr := head
	for curr != nil {
		next := curr.Next
		curr.Next = pre
		pre = curr
		curr = next
	}
	return pre
}
