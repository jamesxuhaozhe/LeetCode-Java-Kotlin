package main

// Problem link: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
// use recursion to swap two adjacent nodes
func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	second := head.Next
	third := second.Next
	second.Next = head
	head.Next = swapPairs(third)

	return second
}
