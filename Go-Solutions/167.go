package main

//func main() {
//
//}

func twoSum_167(numbers []int, target int) []int {
	start := 0
	last := len(numbers) - 1
	for start < last {
		sum := numbers[start] + numbers[last]
		if sum == target {
			return []int{start + 1, last + 1}
		}
		if sum < target {
			start++
		} else {
			last--
		}
	}

	return nil
}

func twoSum11(numbers []int, target int) []int {
	if numbers == nil {
		return nil
	}

	left, right := 0, len(numbers)-1
	for left < right {
		sum := numbers[left] + numbers[right]
		// if sum == target, it means you have found your solutions
		if sum == target {
			return []int{left + 1, right + 1}
		}
		// if sum is less than the target, then your only chance is to move the left to the right
		if sum < target {
			left++
		} else {
			// in this branch, it means your only chance is to move the right to the left
			right--
		}
	}
	return nil
}
