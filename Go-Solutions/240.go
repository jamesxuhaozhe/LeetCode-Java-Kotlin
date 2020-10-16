package main

// Problem link: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
// sol: https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5vl81e/
func searchMatrix(matrix [][]int, target int) bool {
	if !isValidMat240(matrix) {
		return false
	}

	m := len(matrix)
	n := len(matrix[0])
	i := m - 1
	j := 0
	for i >= 0 && j < n {
		flag := matrix[i][j]
		if flag > target {
			i--
		} else if flag < target {
			j++
		} else {
			return true
		}
	}

	return false
}

func isValidMat240(matrix [][]int) bool {
	if len(matrix) == 0 {
		return false
	}

	if len(matrix[0]) == 0 {
		return false
	}

	return true
}

func searchMatrix2(matrix [][]int, target int) bool {
	if !isValidMat(matrix) {
		return false
	}

	m, n := len(matrix), len(matrix[0])
	i := m - 1
	j := 0
	for i >= 0 && j < n {
		cur := matrix[i][j]
		if cur == target {
			return true
		} else if cur < target {
			j++
		} else {
			i--
		}
	}
	return false
}

func isValidMat(matrix [][]int) bool {
	if matrix == nil {
		return false
	}

	if len(matrix) == 0 {
		return false
	}

	if len(matrix[0]) == 0 {
		return false
	}

	return true
}