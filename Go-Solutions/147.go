package main

// solution: https://leetcode-cn.com/problems/insertion-sort-list/solution/147-dui-lian-biao-jin-xing-cha-ru-pai-xu-by-alexer/
func insertionSortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	dummy := &ListNode{
		Val:  0,
		Next: nil,
	}

	cur, pre := head, dummy
	for cur != nil {
		next := cur.Next
		for pre.Next != nil && pre.Next.Val < cur.Val {
			pre = pre.Next
		}
		cur.Next = pre.Next
		pre.Next = cur
		pre = dummy
		cur = next
	}
	return dummy.Next
}
