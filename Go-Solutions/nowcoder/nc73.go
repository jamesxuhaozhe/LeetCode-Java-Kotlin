package nowcoder

import "sort"

func MoreThanHalfNum_Solution(numbers []int) int {
	// write code here
	sort.Ints(numbers)
	mid := numbers[len(numbers)/2]
	count := 0
	for _, v := range numbers {
		if v == mid {
			count++
		}
	}
	if count > len(numbers)/2 {
		return mid
	}
	return 0
}
