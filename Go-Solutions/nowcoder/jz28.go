package nowcoder

import "sort"

func MoreThanHalfNum_Solutionjz28(nums []int) int {
	// write code here
	if len(nums) == 0 {
		return 0
	}

	sort.Ints(nums)
	mid := nums[len(nums)/2]
	count := 0
	for _, v := range nums {
		if v == mid {
			count++
		}
	}
	if count > len(nums)/2 {
		return mid
	}

	return 0
}
