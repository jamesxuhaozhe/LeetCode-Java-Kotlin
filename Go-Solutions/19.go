package main

// sol: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	dummy := &ListNode{
		Val:  -1,
		Next: head,
	}
	length := 0
	cur := head
	for cur != nil {
		length++
		cur = cur.Next
	}

	runner := dummy
	for i := 0; i < length - n; i++ {
		runner = runner.Next
	}
	runner.Next = runner.Next.Next
	return dummy.Next
}

func removeNthFromEnd2(head *ListNode, n int) *ListNode {
	dummy := &ListNode{
		Val:  -1,
		Next: head,
	}
	slow, fast := dummy, dummy
	for i := 0; i < n + 1; i++ {
		fast = fast.Next
	}

	for fast != nil {
		fast = fast.Next
		slow = slow.Next
	}
	slow.Next = slow.Next.Next
	return dummy.Next
}
