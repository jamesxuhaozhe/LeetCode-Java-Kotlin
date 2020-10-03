package main

// Problem link: https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
// same as offer 11 logn
func findMin(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}

	i, j := 0, len(nums)-1
	for i < j {
		m := (i + j) / 2
		if nums[m] > nums[j] {
			i = m + 1
		} else if nums[m] < nums[j] {
			j = m
		} else {
			j--
		}
	}
	return nums[i]
}
