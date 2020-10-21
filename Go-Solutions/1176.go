package main

// 很简单的题，非常经典的固定长度K的滑动窗口题目，只需要维护一个变量，windowT来记录窗口K中的总T，然后每个窗口中，要根据条件计算score
func dietPlanPerformance(calories []int, k int, lower int, upper int) int {
	//当前的score
	score := 0
	//windowT来记录窗口K中的总T
	windowT := 0
	left, right := 0, 0
	for right < len(calories) {
		windowT += calories[right]

		//窗口的大小为k的时候，我们需要维护windowT和score的值，同时从今往后，left和right都是同时向前进，保持一个固定大小K的窗口
		if right-left+1 == k {
			if windowT < lower {
				score--
			}
			if windowT > upper {
				score++
			}
			windowT -= calories[left]
			left++
		}
		right++
	}
	return score
}
