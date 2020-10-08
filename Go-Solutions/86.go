package main

// https://leetcode-cn.com/problems/partition-list/solution/javaliang-lian-biao-pin-jie-100-by-connors-tomatod/
// 用两个dummy头，遍历原链表一次
func partition(head *ListNode, x int) *ListNode {
	minDummy := &ListNode{
		Val:  0,
		Next: nil,
	}
	maxDummy := &ListNode{
		Val:  0,
		Next: nil,
	}

	minRunner, maxRunner := minDummy, maxDummy
	for head != nil {
		if head.Val < x {
			minRunner.Next = head
			minRunner = minRunner.Next
		} else {
			maxRunner.Next = head
			maxRunner = maxRunner.Next
		}
		head = head.Next
	}

	// 这里要置空，否则会出现环形链表
	maxRunner.Next = nil
	minRunner.Next = maxDummy.Next
	return minDummy.Next
}
