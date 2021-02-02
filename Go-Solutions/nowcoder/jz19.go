package nowcoder

func printMatrix(matrix [][]int) []int {
	// write code here

	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return []int{}
	}

	left, right := 0, len(matrix[0])-1
	low, high := 0, len(matrix)-1

	res := make([]int, 0)
	for low <= high && left <= right {
		for i := left; i <= right; i++ {
			res = append(res, matrix[low][i])
		}

		for i := low + 1; i <= high; i++ {
			res = append(res, matrix[i][right])
		}
		//向左 有可能出现特殊的情况只有一行，为了避免重复访问
		if low < high {
			for i := right - 1; i >= left; i-- {
				res = append(res, matrix[high][i])
			}
		}

		//向上 有可能出现特殊的情况只有一列，为了避免重复访问
		if left < right {
			for i := high - 1; i >= low+1; i-- {
				res = append(res, matrix[i][left])
			}
		}

		left++
		low++
		right--
		high--
	}
	return res
}
