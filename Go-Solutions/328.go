package main

func oddEvenList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	odd := head
	even := odd.Next
	evenHead := even

	for even != nil && even.Next != nil {
		odd.Next = even.Next
		odd = odd.Next

		even.Next = odd.Next
		even = even.Next
	}
	odd.Next = evenHead
	return head
}

// 用两个哨兵模式，很优雅， 与86题是一样的
func oddEvenList1(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	oddHead := &ListNode{
		Val:  0,
		Next: nil,
	}
	evenHead := &ListNode{
		Val:  0,
		Next: nil,
	}

	oddRunner, evenRunner := oddHead, evenHead
	cur := head
	count := 1
	for cur != nil {
		if count%2 == 1 {
			oddRunner.Next = cur
			oddRunner = oddRunner.Next
		} else {
			evenRunner.Next = cur
			evenRunner = evenRunner.Next
		}
		count++
		cur = cur.Next
	}
	oddRunner.Next = evenHead.Next
	// 注意这里需要断开指针，否则结果可能是环状
	evenRunner.Next = nil
	return oddHead.Next
}

//func main() {
//	one := &ListNode{
//		Val:  2,
//		Next: nil,
//	}
//
//	two := &ListNode{
//		Val:  1,
//		Next: nil,
//	}
//
//	three := &ListNode{
//		Val:  3,
//		Next: nil,
//	}
//
//	four := &ListNode{
//		Val:  5,
//		Next: nil,
//	}
//
//	five := &ListNode{
//		Val:  6,
//		Next: nil,
//	}
//
//	six := &ListNode{
//		Val:  4,
//		Next: nil,
//	}
//
//	seven := &ListNode{
//		Val:  7,
//		Next: nil,
//	}
//
//	one.Next = two
//	two.Next = three
//	three.Next = four
//	four.Next = five
//	five.Next = six
//	six.Next = seven
//
//	head := oddEvenList1(one)
//
//	for head != nil {
//		fmt.Println(head.Val)
//		head = head.Next
//	}
//
//}
