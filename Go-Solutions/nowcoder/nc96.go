package nowcoder

func isPail96(head *ListNode) bool {
	// write code here
	reversed := reverse96(head)
	for reversed != nil && head != nil {
		if reversed.Val != head.Val {
			return false
		}
		reversed = reversed.Next
		head = head.Next
	}
	return true
}

func reverse96(head *ListNode) *ListNode {
	res := &ListNode{Val: -1, Next: nil,}

	p := head
	for p != nil {
		t := &ListNode{Val: p.Val, Next: res.Next,}
		res.Next = t
		p = p.Next
	}
	return res.Next
}
