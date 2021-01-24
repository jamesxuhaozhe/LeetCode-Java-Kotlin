package nowcoder

import "sort"

// sol: https://leetcode-cn.com/problems/maximum-product-of-three-numbers/solution/bu-fei-nao-zi-du-neng-kan-dong-de-jie-xi-69bd/

func solve106(A []int) int64 {
	// write code here
	if len(A) < 3 {
		return -1
	}
	sort.Ints(A)
	length := len(A)
	return max106(int64(A[length-1]*A[length-2]*A[length-3]), int64(A[0]*A[1]*A[length-1]))
}

func max106(a, b int64) int64 {
	if a > b {
		return a
	}
	return b
}
