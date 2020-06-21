package main

func singleNonDuplicate(nums []int) int {
	if len(nums) == 0 {
		panic("no solution")
	}

	length := len(nums)
	for i := 0; i < length-1; i += 2 {
		if nums[i] != nums[i+1] {
			return nums[i]
		}
	}

	return nums[length-1]
}

func singleNonDuplicate1(nums []int) int {
	if len(nums) == 0 {
		panic("no solution")
	}
	helperMap := make(map[int]int)
	for _, num := range nums {
		if value, ok := helperMap[num]; ok {
			helperMap[num] = value + 1
		} else {
			helperMap[num] = 1
		}
	}

	for k, v := range helperMap {
		if v == 1 {
			return k
		}
	}

	panic("No Solution")
}

func singleNonDuplicate2(nums []int) int {
	first := nums[0]
	for i := 1; i < len(nums); i++ {
		first = first ^ nums[i]
	}
	return first
}

func singleNonDuplicate3(nums []int) int {
	length := len(nums)
	if length == 0 {
		panic("no solution")
	}

	low := 0
	high := length - 1
	for low < high {
		mid := low + (high-low)/2
		isEven := (high-mid)%2 == 0
		if nums[mid+1] == nums[mid] {
			if isEven {
				low = mid + 2
			} else {
				high = mid - 1
			}
		} else if nums[mid-1] == nums[mid] {
			if isEven {
				high = mid - 2
			} else {
				low = mid + 1
			}
		} else {
			return nums[mid]
		}
	}

	return nums[low]
}
