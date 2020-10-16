package main

//看注释，这道题自己做的
func searchMatrix74(matrix [][]int, target int) bool {

	// 如果根本不是一个valid 矩阵，直接返回false
	if !isValidMat74(matrix) {
		return false
	}

	m, n := len(matrix), len(matrix[0])
	// 如果比矩阵中的最小值还小，直接返回false
	if target < matrix[0][0] {
		return false
	}

	// 如果比矩阵中的最大值还大，直接返回false
	if target > matrix[m-1][n-1] {
		return false
	}

	//在最左边的一列上，找到不大于target的最后一个row index
	rowIdx := searchLastLessOrEqualIdx(matrix, target)
	lastNumOnRowIdx := matrix[rowIdx][n-1]
	// 如果rowIdx这行上最大的值都比target要小，那么肯定是false
	if target > lastNumOnRowIdx {
		return false
	}

	// 在rowIdx这行上进行二分查找，能找到就返回true，找不到就返回false
	low, high := 0, n-1
	for low <= high {
		mid := low + (high-low)>>1
		if matrix[rowIdx][mid] == target {
			return true
		} else if matrix[rowIdx][mid] < target {
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return false
}

func searchLastLessOrEqualIdx(matrix [][]int, target int) int {
	low, high := 0, len(matrix)-1
	for low <= high {
		mid := low + (high-low)>>1
		if matrix[mid][0] == target {
			return mid
		} else if matrix[mid][0] > target {
			high = mid - 1
		} else {
			if (mid == len(matrix)-1) || (matrix[mid+1][0] > target) {
				return mid
			}
			low = mid + 1
		}
	}
	return -1
}

func isValidMat74(matrix [][]int) bool {
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

//func main() {
//	matrix := [][]int{
//		{1},
//		{3},
//	}
//
//	k := 3
//	searchMatrix74(matrix, k)
//}

func searchMatrix74_2(matrix [][]int, target int) bool {
	if len(matrix) == 0 {
		return false
	}
	m, low, high := len(matrix[0]), 0, len(matrix[0])*len(matrix)-1
	for low <= high {
		mid := low + (high-low)>>1
		// row is mid / m, mid % m
		if matrix[mid/m][mid%m] == target {
			return true
		} else if matrix[mid/m][mid%m] > target {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return false
}


