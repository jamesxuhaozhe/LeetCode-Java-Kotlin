package main

func isPalindrome_ok(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}

	arr := make([]int, 0)
	for head != nil {
		arr = append(arr, head.Val)
		head = head.Next
	}

	i, j := 0, len(arr)-1
	for i < j {
		if arr[i] != arr[j] {
			return false
		}
		i++
		j--
	}
	return true
}

//https://leetcode-cn.com/problems/palindrome-linked-list/solution/you-shi-yi-dao-si-lu-qing-xi-ming-liao-de-ti-mu-by/
func isPalindrome_better(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}

	middleNode := getMiddleNode234(head)
	secondHead := reverseList234(middleNode)
	for secondHead != nil {
		if secondHead.Val != head.Val {
			return false
		}
		secondHead = secondHead.Next
		head = head.Next
	}
	return true
}

func reverseList234(head *ListNode) *ListNode {
	cur := head
	var newHead *ListNode = nil
	var next *ListNode = nil
	for cur != nil {
		next = cur.Next
		cur.Next = newHead
		newHead = cur
		cur = next
	}
	return newHead
}

func getMiddleNode234(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}
