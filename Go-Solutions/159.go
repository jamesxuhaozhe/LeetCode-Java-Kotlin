package main

import "math"

// https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/solution/zhi-duo-bao-han-liang-ge-bu-tong-zi-fu-de-zui-chan/
func lengthOfLongestSubstringTwoDistinct(s string) int {
	sLen := len(s)
	if sLen < 3 {
		return sLen
	}

	left, right := 0, 0
	// 我们用hashmap 来记录窗口中每个字符的最右下标
	table := make(map[byte]int)
	res := 2
	for right < sLen {
		if len(table) < 3 {
			table[s[right]] = right
			right++
		}

		if len(table) == 3 {
			idx := getMapMinValue(table)
			left = idx + 1
			delete(table, s[idx])
		}
		res = max159(res, right - left)
	}
	return res
}

func max159(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func getMapMinValue(table map[byte]int) int {
	min := math.MaxInt64
	for _, value := range table {
		if value < min {
			min = value
		}
	}
	return min
}
