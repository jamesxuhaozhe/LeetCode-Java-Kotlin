package main

func missingNumber(nums []int) int {
	n := len(nums)
	expectedSum := n * (n + 1) / 2

	actualSum := 0
	for _, v := range nums {
		actualSum += v
	}

	return expectedSum - actualSum
}
