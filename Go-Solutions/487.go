package main

import "math"

// 跟1004是一样的，只不过487是1004的特殊情况，把1004的K改成1就可以了
func findMaxConsecutiveOnes_487(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	if 1 >= len(nums) {
		return len(nums)
	}

	// 记录窗口中0的个数
	count := 0
	res := math.MinInt64
	left, right := 0, 0
	for right < len(nums) {
		if nums[right] == 0 {
			count++
		}
		for count > 1 {
			if nums[left] == 0 {
				count--
			}
			left++
		}
		res = max1004(res, right - left + 1)
		right++
	}
	return res
}

func max487(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
