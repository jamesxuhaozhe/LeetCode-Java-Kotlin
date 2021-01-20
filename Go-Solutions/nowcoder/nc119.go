package nowcoder

import "sort"

// todo use heap
//https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/tu-jie-top-k-wen-ti-de-liang-chong-jie-fa-you-lie-/
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
