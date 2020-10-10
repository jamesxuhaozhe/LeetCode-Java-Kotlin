package main

// 首先看长度是多少，如果k是长度的整数倍，那么什么都不需要做，直接返回head，如果有余数的话，就通过two pointer找到需要
// 拆分的前驱，然后进行重新拼接
func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil || k == 0 {
		return head
	}

	k = k % getLen61(head)
	if k == 0 {
		return head
	}

	dummy := &ListNode{
		Val:  0,
		Next: head,
	}
	slow, fast := dummy, dummy
	for i := 0; i < k; i++ {
		fast = fast.Next
	}

	for fast.Next != nil {
		slow = slow.Next
		fast = fast.Next
	}

	headOfRemained := slow.Next
	slow.Next = nil
	dummy.Next = headOfRemained
	fast.Next = head
	return dummy.Next
}

func getLen61(head *ListNode) int {
	cur := head
	count := 0
	for cur != nil {
		cur = cur.Next
		count++
	}
	return count
}
