package main

import "sort"

func sortedSquares(A []int) []int {
	n := len(A)
	result := make([]int, n, n)
	for i := 0; i < n; i++ {
		result[i] = A[i] * A[i]
	}
	sort.Ints(result)
	return result
}