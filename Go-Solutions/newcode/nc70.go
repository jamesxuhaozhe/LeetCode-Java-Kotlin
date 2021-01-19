package newcode

func sortInList70(head *ListNode) *ListNode {
	// write code here
	if head == nil || head.Next == nil {
		return head
	}
	midNode := getMidNode70(head)
	remained := midNode.Next
	midNode.Next = nil
	left := sortInList70(head)
	right := sortInList70(remained)
	return mergeSortedList70(left, right)
}

func getMidNode70(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	slow, fast := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}

func mergeSortedList70(left, right *ListNode) *ListNode {
	if left == nil && right == nil {
		return nil
	}
	if left == nil {
		return right
	}
	if right == nil {
		return left
	}

	dummy := &ListNode{Val: -1, Next: nil,}
	runner := dummy
	for left != nil && right != nil {
		if left.Val < right.Val {
			runner.Next = left
			left = left.Next
		} else {
			runner.Next = right
			right = right.Next
		}
		runner = runner.Next
	}
	if left != nil {
		runner.Next = left
	}
	if right != nil {
		runner.Next = right
	}
	return dummy.Next
}
