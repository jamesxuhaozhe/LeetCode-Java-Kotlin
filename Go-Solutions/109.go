package main

//func main() {
//
//}

func sortedListToBST(head *ListNode) *TreeNode {
	if head == nil {
		return nil
	}

	mid := findMiddleNode(head)
	root := &TreeNode{
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

func findMiddleNode(head *ListNode) *ListNode {
	var pre *ListNode = nil
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
