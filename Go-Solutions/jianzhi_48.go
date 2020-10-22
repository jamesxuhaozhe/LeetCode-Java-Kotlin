package main

// like problem 3
func lengthOfLongestSubstring_jianzhi_48(s string) int {
	if len(s) == 0 {
		return 0
	}

	res := 0
	left, right := 0, 0
	var flag [256]int
	for right < len(s) {
		if flag[s[right] - 'a'] == 0 {
			flag[s[right] - 'a']++
			right++
		} else {
			flag[s[left] - 'a']--
			left++
		}
		res = max_jianzhi_48(res, right - left)
	}
	return res
}

func max_jianzhi_48(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

//func main() {
//	s := "abcabcbb"
//	fmt.Println(lengthOfLongestSubstring_jianzhi_48(s))
//}