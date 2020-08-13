package main

func findMaxConsecutiveOnes(nums []int) int {
	count := 0
	maxCount := 0
	for _, v := range nums {
		if v == 1 {
			count++
		} else {
			maxCount = ma(count, maxCount)
			count = 0
		}
	}
	return ma(count, maxCount)
}

func ma(count int, count2 int) int {
	if count > count2 {
		return count
	} else {
		return count2
	}
}
