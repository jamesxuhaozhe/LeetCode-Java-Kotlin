package main

func findRepeatNumber(nums []int) int {
	numSet := make(map[int]bool)
	for _, num := range nums {
		if numSet[num] {
			return num
		} else {
			numSet[num] = true
		}
	}

	return 0
}
