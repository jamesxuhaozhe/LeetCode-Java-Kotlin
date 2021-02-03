package nowcoder

func GetNumberOfKjz37(data []int, k int) int {
	// write code here
	if len(data) == 0 {
		return 0
	}

	farLeftIdx := getFarLeftIdx(data, k)
	if farLeftIdx == -1 {
		return 0
	}
	farRightIdx := getFarRightIdx(data, k)
	return farRightIdx - farLeftIdx + 1
}

func getFarLeftIdx(data []int, k int) int {
	left, right := 0, len(data)-1
	for left <= right {
		mid := left + (right-left)>>1
		if data[mid] < k {
			left = mid + 1
		} else if k < data[mid] {
			right = mid - 1
		} else {
			if mid == 0 || data[mid-1] != k {
				return mid
			}
			right = mid - 1
		}
	}
	return -1
}

func getFarRightIdx(data []int, k int) int {
	left, right := 0, len(data)-1
	for left <= right {
		mid := left + (right-left)>>1
		if data[mid] < k {
			left = mid + 1
		} else if k < data[mid] {
			right = mid - 1
		} else {
			if mid == len(data)-1 || data[mid+1] != k {
				return mid
			}
			left = mid + 1
		}

	}
	return -1
}
