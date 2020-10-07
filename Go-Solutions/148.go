package main

// use merge sort, the sol for problem 21 and 876 are useful,
func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	middleNode := getMiddleNode(head)
	tmp := middleNode.Next
	middleNode.Next = nil
	secHead := tmp
	left := sortList(head)
	right := sortList(secHead)
	return mergeTwoSortedList148_2(left, right)
}

func mergeTwoSortList148_1(left *ListNode, right *ListNode) *ListNode {
	if left == nil {
		return right
	}
	if right == nil {
		return left
	}

	if left.Val < right.Val {
		left.Next = mergeTwoSortList148_1(left.Next, right)
		return left
	}
	right.Next = mergeTwoSortList148_1(left, right.Next)
	return right
}

func mergeTwoSortedList148_2(left *ListNode, right *ListNode) *ListNode {
	dummy := &ListNode{
		Val:  -1,
		Next: nil,
	}
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

func getMiddleNode(head *ListNode) *ListNode {
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
