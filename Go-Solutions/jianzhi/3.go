package jianzhi

import "sort"

// Problem link: https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
// O n
func findRepeatNumber(nums []int) int {
	for i := 0; i < len(nums); i++ {
		for nums[i] != i {
			if nums[i] == nums[nums[i]] {
				return nums[i]
			}

			m := nums[i]
			nums[i], nums[m] = nums[m], nums[i]
		}
	}

	return -1
}

func findRepeatNumber1(nums []int) int {
	sort.Ints(nums)
	for i := 1; i < len(nums); i++ {
		if nums[i] == nums[i-1] {
			return nums[i]
		}
	}
	return -1
}

func findRepeatNumber2(nums []int) int {
	arr := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		arr[nums[i]]++
		if arr[nums[i]] > 1 {
			return nums[i]
		}
	}

	return -1
}
