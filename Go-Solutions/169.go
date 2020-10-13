package main

import "sort"

func majorityElement(nums []int) int {
	n := len(nums)
	sort.Ints(nums)
	return nums[n/2]
}
