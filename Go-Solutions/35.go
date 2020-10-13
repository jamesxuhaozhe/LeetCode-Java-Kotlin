package main

// 这一题是经典的二分搜索的变种题，在有序数组中找到最后一个比 target 小的元素。
func searchInsert(nums []int, target int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)>>1
		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			if (mid == len(nums)-1) || (nums[mid+1] > target) {
				return mid + 1
			}
			left = mid + 1
		}
	}
	return 0
}
