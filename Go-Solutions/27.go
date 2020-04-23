package main

func removeElement(nums []int, val int) int {
	i := 0
	for _, value := range nums {
		if value != val {
			nums[i] = value
			i++
		}
	}
	return i
}
