package main

import "math"

// https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
// sliding windows
func minSubArrayLen(s int, nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}

	start := 0
	end := 0
	ans := math.MaxInt32
	sum := 0
	len := len(nums)
	for end < len {
		sum += nums[end]
		for sum >= s {
			ans = min209(ans, end - start + 1)
			sum -= nums[start]
			start++
		}
		end++
	}
	if ans == math.MaxInt32 {
		return 0
	}
	return ans
}

func min209(num1 int, num2 int) int {
	if num1 > num2 {
		return num2
	}
	return num1
}
