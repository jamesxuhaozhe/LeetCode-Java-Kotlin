package main

func findRepeatNumber(nums []int) int {
	numSet := make(map[int]bool)
	for _, num := range nums {
		if numSet[num] {
			return num
		} else {
			numSet[num] = true
		}
	}

	return 0
}

// 滑动窗口
func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 {
		return 0
	}

	var flag [256]int
	result, left, right := 0, 0, -1
	for left < len(s) {
		if right+1 < len(s) && flag[s[right+1]-'a'] == 0 {
			flag[s[right+1]-'a']++
			right++
		} else {
			flag[s[left]-'a']--
			left++
		}
		result = max3(result, right-left+1)
	}
	return result
}

func max3(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
