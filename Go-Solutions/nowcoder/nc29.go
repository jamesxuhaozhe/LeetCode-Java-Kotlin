package nowcoder

func searchMatrix29(matrix [][]int, target int) bool {
	// write code here
	if matrix == nil {
		return false
	}

	m := len(matrix)
	if m == 0 {
		return false
	}

	n := len(matrix[0])
	if n == 0 {
		return false
	}

	start, end := 0, m*n-1
	for start <= end {
		mid := start + (end-start)>>1
		i, j := mid/n, mid%n
		if matrix[i][j] == target {
			return true
		} else if target < matrix[i][j] {
			end = mid - 1
		} else {
			start = mid + 1
		}
	}
	return false
}
