package nowcoder

func ReverseList(pHead *ListNode) *ListNode {
	// write code here
	var newHead *ListNode = nil
	var next *ListNode = nil
	runner := pHead
	for runner != nil {
		next = runner.Next
		runner.Next = newHead
		newHead = runner
		runner = next
	}
	return newHead
}
