package main

func isMajorityElement(nums []int, target int) bool {
	count := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] == target {
			count++
		}
	}
	return count > len(nums)/2
}

func isMajorityElement1(nums []int, target int) bool {
	farleftIndex, farRightIndex := getFarLeftIndex1150(nums, target), getFarRightIndex1150(nums, target)
	if farleftIndex == -1 || farRightIndex == -1 {
		return false
	}

	return (farRightIndex - farleftIndex + 1) > len(nums)/2
}

func getFarRightIndex1150(nums []int, target int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)>>1
		if nums[mid] > target {
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			if (mid == len(nums)-1) || (nums[mid+1] != target) {
				return mid
			}
			left = mid + 1
		}
	}
	return -1
}

func getFarLeftIndex1150(nums []int, target int) int {
	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)>>1
		if nums[mid] > target {
			right = mid - 1
		} else if nums[mid] < target {
			left = mid + 1
		} else {
			if (mid == 0) || (nums[mid-1] != target) {
				return mid
			}
			right = mid - 1
		}
	}
	return -1
}
