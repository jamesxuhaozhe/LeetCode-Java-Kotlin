package main

// solution is https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/yi-wen-jie-jue-4-dao-sou-suo-xuan-zhuan-pai-xu-s-3/
// 33 81 153 154 这四道题可以一起看，都是关于旋转数组的
func findMin153(nums []int) int {
	low, high := 0, len(nums) - 1
	for low <= high {
		if nums[low] <= nums[high] {
			return nums[low]
		}
		mid := low + (high - low)>> 1
		if nums[low] <= nums[mid] {
			low = mid + 1
		} else {
			high = mid
		}
	}
	return -1
}
