package nowcoder

func oddEvenList(head *ListNode) *ListNode {
	// write code here
	if head == nil || head.Next == nil {
		return head
	}

	oddDummy, evenDummy := &ListNode{Val: -1, Next: nil,}, &ListNode{Val: -1, Next: nil,}
	oddRunner, evenRunner := oddDummy, evenDummy
	count := 1
	runner := head
	for runner != nil {
		if count%2 == 1 {
			oddRunner.Next = runner
			oddRunner = oddRunner.Next
		} else {
			evenRunner.Next = runner
			evenRunner = evenRunner.Next
		}
		runner = runner.Next
		count++
	}
	evenRunner.Next = nil
	oddRunner.Next = evenDummy.Next
	return oddDummy.Next
}
