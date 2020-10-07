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
