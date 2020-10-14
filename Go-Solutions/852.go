package main

// https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/solution/shan-mai-shu-zu-de-feng-ding-suo-yin-by-leetcode/
func peakIndexInMountainArray(arr []int) int {

	if arr == nil || len(arr) == 0 {
		return -1
	}

	left, right := 0, len(arr)-1
	for left < right {
		mid := left + (right-left)>>1
		if arr[mid] < arr[mid+1] {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return left
}
