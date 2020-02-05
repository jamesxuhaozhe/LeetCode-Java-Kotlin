package main

import (
	"math"
	"sort"
)

func main() {
	
}

func threeSumClosest(nums []int, target int) int {
	sort.Ints(nums)
	ans := nums[0] + nums[1] + nums[2]
	for i := 0; i < len(nums) - 2; i++ {
		start := i + 1
		end := len(nums) - 1
		for start < end {
			localSum := nums[i] + nums[start] + nums[end]
			if int(math.Abs(float64(localSum - target))) < int(math.Abs(float64(ans - target))) {
				ans = localSum
			}
			if localSum < target {
				start++
			} else if localSum > target {
				end--
			} else {
				return ans
			}
		}
	}
	return ans
}
