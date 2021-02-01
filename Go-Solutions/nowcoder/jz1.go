package nowcoder

func Find(target int, array [][]int) bool {
	// write code here
	if !isValidjz1(array) {
		return false
	}

	rows, cols := len(array), len(array[0])
	row, col := rows-1, 0
	for row >= 0 && col < cols {
		if array[row][col] < target {
			col++
		} else if array[row][col] > target {
			row--
		} else {
			return true
		}
	}

	return false
}

func isValidjz1(array [][]int) bool {
	if array == nil || len(array) == 0 || len(array[0]) == 0 {
		return false
	}
	return true
}
