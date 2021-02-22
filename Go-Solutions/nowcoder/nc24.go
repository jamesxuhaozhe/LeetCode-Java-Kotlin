package nowcoder

func deleteDuplicates24(head *ListNode) *ListNode {
	// write code here
	if head == nil || head.Next == nil {
		return head
	}
	dummy := &ListNode{Val: -1, Next: head,}
	prev, cur := dummy, head
	for cur != nil && cur.Next != nil {
		if cur.Val == cur.Next.Val {
			temp := cur.Next
			for temp != nil && temp.Val == cur.Val {
				temp = temp.Next
			}
			prev.Next = temp
			cur = temp
		} else {
			prev = prev.Next
			cur = cur.Next
		}
	}
	return dummy.Next
}
