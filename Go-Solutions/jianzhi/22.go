package jianzhi

func getKthFromEnd(head *ListNode, k int) *ListNode {
	if k < 1 || head == nil {
		return nil
	}

	slow, fast := head, head
	// let fast pointer move k steps first
	for i := 0; i < k; i++ {
		if fast == nil {
			return nil
		}
		fast = fast.Next
	}

	for fast != nil {
		fast = fast.Next
		slow = slow.Next
	}

	return slow
}
