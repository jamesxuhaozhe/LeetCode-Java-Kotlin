package nowcoder

func minNumberInRotateArrayjz6(arr []int) int {
	// write code here
	if len(arr) == 0 {
		return 0
	}

	i, j := 0, len(arr)-1
	for i < j {
		mid := i + (j-i)>>1
		if arr[mid] > arr[j] {
			i = mid + 1
		} else if arr[mid] < arr[j] {
			j = mid
		} else {
			j--
		}
	}
	return arr[i]
}
