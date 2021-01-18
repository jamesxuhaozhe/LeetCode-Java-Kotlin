package newcode

func reverseKGroup( head *ListNode ,  k int ) *ListNode {
	// write code here
	tail := head
	for i := 0; i < k; i++ {
		if tail == nil {
			return head
		}
		tail = tail.Next
	}

	newHead := reverse(head, tail)
	head.Next = reverseKGroup(tail, k)
	return newHead
}

func reverse(head *ListNode, tail *ListNode) *ListNode {
	var newHead *ListNode = nil
	var next *ListNode = nil
	runner := head
	for runner != tail {
		next = runner.Next
		runner.Next = newHead
		newHead = runner
		runner = next
	}
	return newHead
}
