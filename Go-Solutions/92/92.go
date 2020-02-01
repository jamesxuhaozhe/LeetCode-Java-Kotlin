package main

import "Go-Solutions/ds"

func main() {
	
}


func reverseBetween(head *ds.ListNode, m int, n int) *ds.ListNode {
	dummy := &ds.ListNode{
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
	pre.Next = reverse(start)
	start.Next = headOfRemained
	return dummy.Next
}

func reverse(head *ds.ListNode) *ds.ListNode {
	var pre *ds.ListNode = nil
	curr := head
	for curr != nil {
		next := curr.Next
		curr.Next = pre
		pre = curr
		curr = next
	}
	return pre
}