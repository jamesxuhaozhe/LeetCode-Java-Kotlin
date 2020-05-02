package main

import "Go-Solutions/ds"

func main() {

}

func sortedListToBST(head *ds.ListNode) *ds.TreeNode {
	if head == nil {
		return nil
	}

	mid := findMiddleNode(head)
	root := &ds.TreeNode{
		Val:   mid.Val,
		Left:  nil,
		Right: nil,
	}
	if mid == head {
		return root
	}

	left := sortedListToBST(head)
	right := sortedListToBST(mid.Next)
	root.Left = left
	root.Right = right

	return root
}

func findMiddleNode(head *ds.ListNode) *ds.ListNode {
	var pre *ds.ListNode = nil
	slow := head
	fast := head
	for fast != nil && fast.Next != nil {
		pre = slow
		slow = slow.Next
		fast = fast.Next.Next
	}

	if pre != nil {
		pre.Next = nil
	}

	return slow
}
