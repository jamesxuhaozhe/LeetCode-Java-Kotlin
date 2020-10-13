package main

// 套模板就可以了
func searchRange(nums []int, target int) []int {
	left := getFarLeftIndex(nums, target)
	right := getFarRightIndex(nums, target)
	return []int{left, right}
}

func getFarRightIndex(nums []int, target int) int {
	left, right := 0, len(nums) - 1
	for left <= right {
		mid := left + (right - left)>> 1
		if nums[mid] > target {
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			if (mid == len(nums) - 1) || (nums[mid + 1] != target) {
				return mid
			}
			left = mid + 1
		}
	}
	return -1
}

func getFarLeftIndex(nums []int, target int) int {
	left, right := 0, len(nums) - 1
	for left <= right {
		mid := left + (right - left) >> 1
		if nums[mid] > target {
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			if (mid == 0) || (nums[mid-1] != target) {
				return mid
			}
			right = mid - 1
		}
	}
	return -1
}
