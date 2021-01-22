package nowcoder

// https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
func minNumberInRotateArray(rotateArray []int) int {
	// write code here
	if len(rotateArray) == 0 {
		return 0
	}

	i, j := 0, len(rotateArray)-1
	for i < j {
		mid := i + (j-i)>>1
		if rotateArray[mid] > rotateArray[j] {
			i = mid + 1
		} else if rotateArray[mid] < rotateArray[j] {
			j = mid
		} else {
			j--
		}
	}
	return rotateArray[i]
}
