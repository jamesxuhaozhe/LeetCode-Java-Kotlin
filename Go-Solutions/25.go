package main

//https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
// sol: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/di-gui-java-by-reedfan-2/
// 这个题目本质上是跟24一样的，只不过是24的通用解法
func reverseKGroup(head *ListNode, k int) *ListNode {
	node := head
	for i := 0; i < k; i++ {
		if node == nil {
			return head
		}
		node = node.Next
	}
	newHead := reverse25(head, node)
	head.Next = reverseKGroup(node, k)
	return newHead
}

// 左闭右开
func reverse25(first *ListNode, last *ListNode) *ListNode {
	var newHead *ListNode = nil
	for first != last {
		next := first.Next
		first.Next = newHead
		newHead = first
		first = next
	}
	return newHead
}
