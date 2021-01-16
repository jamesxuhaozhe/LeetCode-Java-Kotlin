package newcode

func removeNthFromEnd( head *ListNode ,  n int ) *ListNode {
	// write code here
	dummy := &ListNode{Val: -1, Next: head,}
	slow, fast := dummy, dummy
	for i := 0; i < n; i++ {
		fast = fast.Next
	}
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next
	}
	node := slow.Next
	slow.Next = node.Next
	return dummy.Next
}
