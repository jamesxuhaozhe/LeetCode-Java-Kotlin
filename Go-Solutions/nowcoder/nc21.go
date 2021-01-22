package nowcoder

func reverseBetween( head *ListNode ,  m int ,  n int ) *ListNode {
	// write code here
	if head == nil || head.Next == nil {
		return head
	}

	dummy := &ListNode{Val: 0, Next: head,}

	preStart := dummy
	for i := 0; i < m - 1; i++ {
		preStart = preStart.Next
	}
	start := preStart.Next
	end := preStart
	for i := 0; i < n - m + 1; i++ {
		end = end.Next
	}
	afterEnd := end.Next
	end.Next = nil
	preStart.Next = nil
	newHead := reverse21(start)
	preStart.Next = newHead
	start.Next = afterEnd
	return dummy.Next
}

func reverse21(head *ListNode) *ListNode {
	var newHead *ListNode = nil
	var next *ListNode = nil
	runner := head
	for runner != nil {
		next = runner.Next
		runner.Next = newHead
		newHead = runner
		runner = next
	}
	return newHead
}
