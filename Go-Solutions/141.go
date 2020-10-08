package main

//快慢指针，如果有环的话，那么快指针肯定会超过慢指针一圈，他们会相遇，如果能跳出循环，那么说明根本没有环
func hasCycle(head *ListNode) bool {
	slow, fast := head, head
	for slow != nil && fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			return true
		}
	}
	return false
}
