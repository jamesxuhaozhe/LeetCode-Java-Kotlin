package main

// https://leetcode-cn.com/problems/reorder-list/
// use find middle node and reverse list and merge list
func reorderList(head *ListNode) {
	if head == nil || head.Next == nil {
		return
	}

	middleNode := findMiddleNode143(head)
	right := middleNode.Next
	middleNode.Next = nil
	right = reverse143(right)
	merge143(head, right)
}

func merge143(left *ListNode, right *ListNode) {
	var leftNext *ListNode = nil
	var rightNext *ListNode = nil
	for left != nil && right != nil {
		leftNext = left.Next
		rightNext = right.Next

		left.Next = right
		right.Next = leftNext

		left = leftNext
		right = rightNext
	}
}

func reverse143(head *ListNode) *ListNode {
	var newHead *ListNode = nil
	var next *ListNode = nil
	cur := head
	for cur != nil {
		next = cur.Next
		cur.Next = newHead
		newHead = cur
		cur = next
	}
	return newHead
}

func findMiddleNode143(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}
