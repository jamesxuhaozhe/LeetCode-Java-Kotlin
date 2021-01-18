package newcode

import "sort"

// todo use heap
func GetLeastNumbers_Solution( input []int ,  k int ) []int {
	// write code here
	if k > len(input) {
		return []int{}
	}
	sort.Ints(input)
	res := make([]int, k)
	for i := 0; i < k; i++ {
		res[i] = input[i]
	}
	return res
}
