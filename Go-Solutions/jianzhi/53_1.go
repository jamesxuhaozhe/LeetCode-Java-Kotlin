package jianzhi

// 直接套模板就ok
func search53_1(nums []int, target int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}

	farLeftIdx := getFarLeftIdx(nums, target)
	if farLeftIdx == -1 {
		return 0
	}

	farRightIdx := getFarRightIdx(nums, target)
	return farRightIdx - farLeftIdx + 1
}

func getFarRightIdx(nums []int, target int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)>>1
		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			if (mid == len(nums)-1) || (nums[mid+1] != target) {
				return mid
			}
			left = mid + 1
		}
	}
	return -1
}

func getFarLeftIdx(nums []int, target int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)>>1
		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			if (mid == 0) || (nums[mid-1] != target) {
				return mid
			}
			right = mid - 1
		}
	}
	return -1
}
