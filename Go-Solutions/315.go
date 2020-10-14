package main

// brute force solution
// todo need to use segment tree to redo this problem
func countSmaller(nums []int) []int {
	counts := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		count := 0
		for j := i + 1; j < len(nums); j++ {
			if nums[j] < nums[i] {
				count++
			}
		}
		counts[i] = count
	}
	return counts
}
