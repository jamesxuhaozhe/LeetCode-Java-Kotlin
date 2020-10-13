package main

func isMajorityElement(nums []int, target int) bool {
	count := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] == target {
			count++
		}
	}
	return count > len(nums)/2
}
