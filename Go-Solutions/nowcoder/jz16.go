package nowcoder

func Mergejz16(pHead1 *ListNode, pHead2 *ListNode) *ListNode {
	if pHead1 == nil && pHead2 == nil {
		return nil
	}
	if pHead1 == nil {
		return pHead2
	}
	if pHead2 == nil {
		return pHead1
	}

	// write code here
	dummy := &ListNode{Val: 0, Next: nil}
	runner := dummy

	p1Runner, p2Runner := pHead1, pHead2
	for p1Runner != nil && p2Runner != nil {
		if p1Runner.Val < p2Runner.Val {
			runner.Next = p1Runner
			p1Runner = p1Runner.Next
		} else {
			runner.Next = p2Runner
			p2Runner = p2Runner.Next
		}
		runner = runner.Next
	}
	if p1Runner != nil {
		runner.Next = p1Runner
	}
	if p2Runner != nil {
		runner.Next = p2Runner
	}
	return dummy.Next
}
