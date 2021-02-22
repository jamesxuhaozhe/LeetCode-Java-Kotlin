package nowcoder

func detectCycle(head *ListNode) *ListNode {
	// write code here
	if head == nil || head.Next == nil {
		return nil
	}

	dummy := head

	var convergeNode *ListNode = nil
	hasCycle := false
	convergeNode, hasCycle = converge(head)
	if !hasCycle {
		return nil
	}
	for dummy != convergeNode {
		dummy = dummy.Next
		convergeNode = convergeNode.Next
	}
	return dummy
}

func converge(head *ListNode) (*ListNode, bool) {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			return slow, true
		}
	}
	return nil, false
}
