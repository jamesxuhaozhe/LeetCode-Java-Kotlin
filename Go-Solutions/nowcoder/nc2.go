package nowcoder

func reorderList(head *ListNode) {
	// write code here
	if head == nil || head.Next == nil {
		return
	}

	midNode := getMid(head)
	subHead := midNode.Next
	midNode.Next = nil
	subHead = reverse2(subHead)

	dummy := &ListNode{Val: -1, Next: nil,}
	dRunner := dummy
	runner := head
	for runner != nil || subHead != nil {
		if runner != nil {
			dRunner.Next = runner
			runner = runner.Next
			dRunner = dRunner.Next
		}
		if subHead != nil {
			dRunner.Next = subHead
			subHead = subHead.Next
			dRunner = dRunner.Next
		}
	}
}

func reverse2(head *ListNode) *ListNode {
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

func getMid(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}
