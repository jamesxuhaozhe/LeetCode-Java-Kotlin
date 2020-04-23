package main

func search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}

	start := 0
	end := len(nums) - 1
	for start <= end {
		mid := (start + end) / 2
		if target == nums[mid] {
			return mid
		}
		if target < nums[mid] {
			end = mid - 1
		}
		if target > nums[mid] {
			start = mid + 1
		}
	}

	return -1
}