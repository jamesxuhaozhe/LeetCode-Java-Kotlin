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

// https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/jian-dan-di-gui-bi-xu-miao-dong-by-sweetiee-3/
func sortedListToBST_1(head *ListNode) *TreeNode {
	if head == nil {
		return nil
	}

	if head.Next == nil {
		return &TreeNode{
			Val:   head.Val,
			Left:  nil,
			Right: nil,
		}
	}

	slow, fast := head, head
	var pre *ListNode = nil
	for fast.Next != nil && fast.Next.Next != nil {
		pre = slow
		slow = slow.Next
		fast = fast.Next.Next
	}

	if pre != nil {
		pre.Next = nil
	}

	if slow == head {
		head = nil
	}

	root := &TreeNode{
		Val:   slow.Val,
		Left:  sortedListToBST_1(head),
		Right: sortedListToBST_1(slow.Next),
	}
	return root
}

// https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/jian-dan-di-gui-bi-xu-miao-dong-by-sweetiee-3/
func sortedListToBST_2(head *ListNode) *TreeNode {
	if head == nil {
		return nil
	}

	if head.Next == nil {
		return &TreeNode{
			Val:   head.Val,
			Left:  nil,
			Right: nil,
		}
	}

	slow, fast := head, head
	var pre *ListNode = nil
	for fast != nil && fast.Next != nil {
		pre = slow
		slow = slow.Next
		fast = fast.Next.Next
	}

	if pre != nil {
		pre.Next = nil
	}

	root := &TreeNode{
		Val:   slow.Val,
		Left:  sortedListToBST_2(head),
		Right: sortedListToBST_2(slow.Next),
	}
	return root
}
