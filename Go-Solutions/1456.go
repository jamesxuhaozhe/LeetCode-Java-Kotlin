package main

// 很典型的一道滑动窗口大小为固定K的题目
func maxVowels(s string, k int) int {
	if k > len(s) {
		return 0
	}

	// count 来记录当前窗口中元音的个数
	count := 0
	max := 0
	left, right := 0, 0
	for right < len(s) {
		// 如果当前的这个是元音的话，那么count就要增加
		if isVowel1456(s[right]) {
			count++
		}
		// 当当前窗口的长度正好是K的时候
		if right-left+1 == k {
			// 需要更新max
			max = max1456(max, count)
			// 因为最左边的元素即将离开窗口，需要看一下他是不是元音，是的话，那么要从count中减1
			if isVowel1456(s[left]) {
				count--
			}
			// 滑动窗口
			left++
		}
		// 滑动窗口
		right++
	}
	return max
}

func max1456(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

// 判断字符是否是元音字母
func isVowel1456(ch byte) bool {
	if ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' {
		return true
	}
	return false
}

//func main() {
//	s := "rhythms"
//	k := 4
//	fmt.Println(maxVowels(s, k))
//}
