package main

// sol: Floyed 算法，先找到快慢指针相遇的节点，然后head和相遇节点同时开始往前进，相遇的地方即为环上的第一个节点
// https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/
func detectCycle(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}
	intersecNode := hashCycle142(head)
	if intersecNode == nil {
		return nil
	}

	for head != intersecNode {
		head = head.Next
		intersecNode = intersecNode.Next
	}
	return head
}

func hashCycle142(head *ListNode) *ListNode {
	slow, fast := head, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			return slow
		}
	}
	return nil
}
