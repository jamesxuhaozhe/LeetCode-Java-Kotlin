package main

import "Go-Solutions/jianzhi"

// sol: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-fa-lang-man-xiang-yu-by-ml-zimingm/
func getIntersectionNode_52(headA, headB *jianzhi.ListNode) *jianzhi.ListNode {
	node1, node2 := headA, headB

	for node1 != node2 {
		if node1 != nil {
			node1 = node1.Next
		} else {
			node1 = headB
		}

		if node2 != nil {
			node2 = node2.Next
		} else {
			node2 = headA
		}
	}
	return node1
}
