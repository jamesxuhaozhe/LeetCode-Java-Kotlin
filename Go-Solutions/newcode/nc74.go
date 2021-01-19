package newcode

func GetNumberOfK( data []int ,  k int ) int {
	// write code here
	leftIdx := getFarLeftIndex74(data, k)
	if leftIdx == -1 {
		return 0
	}
	rightIdx := getFarRightIndex74(data, k)
	return rightIdx - leftIdx + 1
}

func getFarLeftIndex74(data []int, target int) int {
	left, right := 0, len(data)-1
	for left <= right {
		mid := left + (right-left)>>1
		if data[mid] > target {
			right = mid - 1
		} else if data[mid] < target {
			left = mid + 1
		} else {
			if mid == 0 || data[mid-1] != target {
				return mid
			}
			right = mid - 1
		}
	}
	return -1
}

func getFarRightIndex74(data []int, target int) int {
	left, right := 0, len(data)-1
	for left <= right {
		mid := left + (right-left)>>1
		if data[mid] > target {
			right = mid - 1
		} else if data[mid] < target {
			left = mid + 1
		} else {
			if mid == len(data)-1 || data[mid+1] != target {
				return mid
			}
			left = mid + 1
		}
	}
	return -1
}
