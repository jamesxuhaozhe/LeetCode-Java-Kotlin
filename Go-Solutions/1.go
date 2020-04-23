package main

func twoSum1(nums []int, target int) []int {
	helperMap := make(map[int]int)
	for i, v := range nums {
		complement := target - v
		if j, ok := helperMap[complement]; ok && (j != i) {
			return []int{i, j}
		}
		helperMap[v] = i
	}
	panic("No solution")
}