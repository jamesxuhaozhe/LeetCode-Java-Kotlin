package newcode

//todo 再用stack做一遍
func addInList( head1 *ListNode ,  head2 *ListNode ) *ListNode {
	// write code here
	if head1 == nil {
		return head2
	}
	if head2 == nil {
		return head1
	}

	l1 := reverse40(head1)
	l2 := reverse40(head2)
	n1, n2, current, carry := 0, 0, &ListNode{Val: 0, Next: nil,}, 0
	head := current
	for l1 != nil || l2 != nil || carry > 0 {
		if l1 == nil {
			n1 = 0
		} else {
			n1 = l1.Val
			l1 = l1.Next
		}
		if l2 == nil {
			n2 = 0
		} else {
			n2 = l2.Val
			l2 = l2.Next
		}
		current.Next = &ListNode{
			Val: (n1+n2+carry)%10,
			Next: nil,
		}
		current = current.Next
		carry = (n1+n2+carry)/10
	}
	return reverse40(head.Next)
}

func reverse40(head *ListNode) *ListNode {
	var newHead *ListNode = nil
	var next *ListNode = nil
	for head != nil {
		next = head.Next
		head.Next = newHead
		newHead = head
		head = next
	}
	return newHead
}
