package main

// https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
func maxSubArray(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	pre, maxAns := 0, nums[0]
	for _, v := range nums {
		pre = max53(pre+v, v)
		maxAns = max53(maxAns, pre)
	}
	return maxAns
}

func max53(a, b int) int {
	if a > b {
		return a
	}
	return b
}