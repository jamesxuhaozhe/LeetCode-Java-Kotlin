package main

import "sort"

// stupid version TODO: use a heap
func getLeastNumbers(arr []int, k int) []int {
	sort.Ints(arr)
	res := make([]int, k)
	for i := 0; i < k; i++ {
		res[i] = arr[i]
	}
	return res
}
