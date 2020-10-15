package main

import "sort"

// the naive solution
func kthSmallest_1(matrix [][]int, k int) int {
	n := len(matrix)
	arr := make([]int, n*n)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			arr[i*n+j] = matrix[i][j]
		}
	}
	sort.Ints(arr)
	return arr[k-1]
}

