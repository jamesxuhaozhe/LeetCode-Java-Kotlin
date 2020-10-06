package main

// Problem link：https://leetcode-cn.com/problems/add-two-numbers/
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{Val: 0}
	n1, n2, carry, current := 0, 0, 0, head
	// l1 不是nil的时候要继续看，l2不是nil的时候要继续看，有carry的时候自然也要继续看
	for l1 != nil || l2 != nil || carry != 0 {
		if l1 == nil {
			n1 = 0
		} else {
			n1 = l1.Val
			l1 = l1.Next
		}
		if l2 == nil {
			n2 = 0
		} else {
			n2 = l2.Val
			l2 = l2.Next
		}
		current.Next = &ListNode{
			Val: (n1 + n2 + carry) % 10,
		}
		current = current.Next
		carry = (n1 + n2 + carry) / 10
	}
	return head.Next
}
