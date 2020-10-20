package main

import "math"

// 此题仍然是滑动窗口，跟159题本质是一样的，是159的通用形式
// 可以参考的题解是：https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters/solution/zhi-shao-bao-han-k-ge-bu-tong-zi-fu-de-zui-chang-z/
// https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/solution/zhi-duo-bao-han-liang-ge-bu-tong-zi-fu-de-zui-chan/
func lengthOfLongestSubstringKDistinct(s string, k int) int {
	sLen := len(s)
	if sLen == 0 || k == 0 {
		return 0
	}

	left, right := 0, 0
	table := make(map[byte]int)
	res := math.MinInt64
	for right < sLen {
		table[s[right]] = right
		right++
		if len(table) == k + 1 {
			idx := getMapMinValue340(table)
			delete(table, s[idx])
			left = idx + 1
		}
		res = max340(res, right - left)
	}
	return res
}

func max340(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func getMapMinValue340(table map[byte]int) int {
	min := math.MaxInt64
	for _, value := range table {
		if value < min {
			min = value
		}
	}
	return min
}

