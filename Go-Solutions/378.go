package main

import (
	"fmt"
	"sort"
)

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
	for i := 0; i < len(arr); i++ {
		fmt.Printf("index: %d, value is: %d\n", i, arr[i])
	}
	return arr[k-1]
}

// https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/guan-fang-ti-jie-er-fen-fa-de-jie-guo-wei-shi-yao-/
func kthSmallest_2(matrix [][]int, k int) int {
	n := len(matrix)
	low := matrix[0][0]
	high := matrix[n-1][n-1]
	mid := 0
	for low <= high {
		mid = low + (high - low) >> 1
		count := getLessEqualCount378(matrix, mid)
		if count == k {
			if getLessEqualCount378(matrix, mid - 1) < k {
				return mid
			}
			//if getLessEqualCount378(matrix, mid - 1) == k
			high = mid - 1
		} else if count < k {
			low = mid + 1
		} else if count > k {
			// 因为matrix中是有可能有重复的数字的
			if getLessEqualCount378(matrix, mid - 1) < k {
				//fmt.Printf("count: %d, mid: %d\n", count, mid)
				return mid
			}
			high = mid - 1
		}
	}
	return mid
}

// 找出不大于mid的count可以参考这个https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/dui-shu-zhi-er-fen-cha-zhao-by-hyj8/
func getLessEqualCount378(matrix [][]int, mid int) int {
	n := len(matrix)
	row := 0
	col := n - 1
	count := 0
	for row < n && col >= 0 {
		if mid >= matrix[row][col] {
			count += col + 1
			row++
		} else {
			col--
		}
	}
	return count
}

//func main() {
//	matrix := [][]int{
//		{1,1,3,8,13},
//		{4,4,4,8,18},
//		{9,14,18,19,20},
//		{14,19,23,25,25},
//		{18,21,26,28,29},
//	}
//	k := 13
//	fmt.Println(kthSmallest_1(matrix, k))
//}