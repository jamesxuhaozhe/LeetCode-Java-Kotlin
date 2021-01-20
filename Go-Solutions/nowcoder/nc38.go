package nowcoder

/**
由于行列不相等，因此定义四个变量用于记录边界：

左边界left
右边界right
上边界top
下边界bottom
然后以top和left基准层层打印，值得注意的是，为了避免重复打印，我们需要在打印下边和左边时额外判断一下top和bottom以及left和right是否相等：
*/
func spiralOrder(matrix [][]int) []int {
	// write code here
	res := make([]int, 0)
	if len(matrix) == 0 {
		return res
	}

	top, left := 0, 0
	right, bottom := len(matrix[0])-1, len(matrix)-1
	for top < (len(matrix)+1)/2 && left < (len(matrix[0])+1)/2 {
		// top， left 往 right 移动
		for i := left; i <= right; i++ {
			res = append(res, matrix[top][i])
		}

		// right， top 往 bottom 移动
		for i := top + 1; i <= bottom; i++ {
			res = append(res, matrix[i][right])
		}

		// bottom right 往 left 移动
		for i := right - 1; i >= left && top != bottom; i-- {
			res = append(res, matrix[bottom][i])
		}

		// left bottom 往 top 移动
		for i := bottom - 1; i >= top+1 && left != right; i-- {
			res = append(res, matrix[i][left])
		}
		top++
		left++
		right--
		bottom--
	}
	return res
}
