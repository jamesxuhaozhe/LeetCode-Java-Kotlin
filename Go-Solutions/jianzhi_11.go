package main

// Problem link: https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
// sol: https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5055b1/
func minArray(numbers []int) int {
	if numbers == nil || len(numbers) == 0 {
		return -1
	}

	i, j := 0, len(numbers)-1
	for i < j {
		m := (i + j) / 2
		if numbers[m] > numbers[j] {
			i = m + 1
		} else if numbers[m] < numbers[j] {
			j = m
		} else {
			j--
		}
	}
	return numbers[i]
}
