package main

//https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-ji-bai-liao-100de-javayong-hu-/
func minWindow(s string, t string) string {
	if len(s) == 0 || len(t) == 0 || len(t) > len(s) {
		return ""
	}

	var need [256]int
	var window [256]int

	for i := 0; i < len(t); i++ {
		need[t[i] - 'a']++
	}

	// 当前window里已经符合条件的字符数量
	count := 0
	left, right := 0, 0
	sLen := len(s)
	minWinLen := len(s) + 1
	res := ""
	for right < sLen {
		ch := s[right] - 'a'
		window[ch]++
		if need[ch] > 0 && need[ch] >= window[ch] {
			count++
		}

		for count == len(t) {
			leftCh := s[left] - 'a'
			if need[leftCh] > 0 && need[leftCh] >= window[leftCh] {
				count--
			}

			if right - left + 1 < minWinLen {
				minWinLen = right - left + 1
				res = s[left:right+1]
			}
			left++
			window[leftCh]--
		}
		right++
	}
	return res
}
