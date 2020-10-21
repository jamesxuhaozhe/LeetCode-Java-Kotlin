package main

// just a little tricky, as long as the value is ok, it is fine
func deleteNode_237(node *ListNode) {
	node.Val = node.Next.Val
	node.Next = node.Next.Next
}
