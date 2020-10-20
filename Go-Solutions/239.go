package main

import (
	"math"
)

// 最直观的解法, 会导致超时
func maxSlidingWindow(nums []int, k int) []int {
	res := make([]int, 0)
	for i := 0; i < len(nums)-k+1; i++ {
		max := math.MinInt64
		for j := i; j < i+k; j++ {
			max = max239(max, nums[j])
		}
		res = append(res, max)
	}
	return res
}

func max239(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

//func main() {
//	nums := []int{1,3,-1,-3,5,3,6,7}
//	fmt.Println(maxSlidingWindow(nums, 3))
//}
//use monotonic queue https://leetcode-cn.com/problems/sliding-window-maximum/solution/239-hua-dong-chuang-kou-zui-da-zhi-by-pasiyu/
// video: https://www.bilibili.com/video/BV1WW411C763?from=search&seid=285136307859851346
func maxSlidingWindow_smart(nums []int, k int) []int {
	if nums == nil || len(nums) == 0 || k > len(nums) {
		return []int{}
	}

	// window 仅仅是存储的index，最左边是最大值，
	// 这本质上是一个monotonic queue
	window := make([]int, 0, len(nums))
	res := make([]int, 0, len(nums))
	for i := 0; i < len(nums); i++ {
		// i - k + 1是窗口中最小的index，当当前window中的最大值已经不在窗口中的时候，我们需要把window最左边的值抛弃掉
		if i >= k && window[0] < i-k+1 {
			window = window[1:]
		}
		// 很经典的，当要往window里面添加元素的时候，需要先把window末端把小于这个元素的值全部剔除掉，注意window添加的本质上是索引，window存储的值是在nums里面
		for len(window) > 0 && nums[window[len(window)-1]] < nums[i] {
			window = window[:len(window)-1]
		}
		window = append(window, i)
		// 当开始出现完整的窗口时
		if i-k+1 >= 0 {
			res = append(res, nums[window[0]])
		}
	}
	return res
}
