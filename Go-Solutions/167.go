package main

//func main() {
//
//}

func twoSum(numbers []int, target int) []int {
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

	left, right := 0, len(numbers) - 1
	for left < right {
		sum := numbers[left] + numbers[right]
		if sum == target {
			return []int{left + 1, right + 1}
		}
		if sum < target {
			left++
		} else {
			right--
		}
	}
	return nil
}