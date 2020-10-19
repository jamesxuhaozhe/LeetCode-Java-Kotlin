package main

//sol https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/tong-guo-ci-ti-liao-jie-yi-xia-shi-yao-shi-hua-don/
func characterReplacement(s string, k int) int {
	if len(s) == 0 {
		return 0
	}

	var window [26]int
	left, right := 0, 0
	sLen := len(s)
	countMax := 0
	for right < sLen {
		window[s[right]-'A']++
		countMax = max424(countMax, window[s[right]-'A'])
		if countMax+k < right-left+1 {
			window[s[left]-'A']--
			left++
		}
		right++
	}
	return sLen - left
}

func max424(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
