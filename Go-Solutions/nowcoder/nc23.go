package nowcoder

func partition23(head *ListNode, x int) *ListNode {
	// write code here
	if head == nil {
		return nil
	}
	lessHead, moreHead := &ListNode{Val: -1, Next: nil,}, &ListNode{Val: -1, Next: nil,}
	lessRunner, moreRunner := lessHead, moreHead
	runner := head
	for runner != nil {
		if runner.Val < x {
			lessRunner.Next = runner
			lessRunner = lessRunner.Next
		} else {
			moreRunner.Next = runner
			moreRunner = moreRunner.Next
		}
		runner = runner.Next
	}
	moreRunner.Next = nil
	lessRunner.Next = moreHead.Next
	return lessHead.Next
}
