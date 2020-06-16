package main

func runningSum(nums []int) []int {
	if nums == nil || len(nums) == 0 {
		return nums
	}
	result := make([]int, len(nums))
	result[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		result[i] = result[i - 1] + nums[i]
	}
	return result
}
