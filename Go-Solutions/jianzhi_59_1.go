package main

// 与239是一样的，用单调队列
func maxSlidingWindow(nums []int, k int) []int {
	if nums == nil || len(nums) == 0 || k > len(nums) {
		return []int{}
	}

	monotonicQueue := make([]int, 0, len(nums))
	res := make([]int, 0, len(nums))

	for i := 0; i < len(nums); i++ {
		if i >= k && monotonicQueue[0] < i-k+1 {
			monotonicQueue = monotonicQueue[1:]
		}
		for len(monotonicQueue) > 0 && nums[monotonicQueue[len(monotonicQueue)-1]] < nums[i] {
			monotonicQueue = monotonicQueue[:len(monotonicQueue)-1]
		}
		monotonicQueue = append(monotonicQueue, i)
		if i-k+1 >= 0 {
			res = append(res, nums[monotonicQueue[0]])
		}
	}
	return res
}
