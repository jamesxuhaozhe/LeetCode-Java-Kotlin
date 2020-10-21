package main

import "Go-Solutions/jianzhi"

// Problem link: https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
func reversePrint(head *jianzhi.ListNode) []int {
	if head == nil {
		return []int{}
	}

	// do one pass
	arr := make([]int, 0)
	for head != nil {
		arr = append(arr, head.Val)
		head = head.Next
	}

	// start reversing the array
	i, j := 0, len(arr)-1
	for i < j {
		arr[i], arr[j] = arr[j], arr[i]
		i++
		j--
	}

	return arr
}
