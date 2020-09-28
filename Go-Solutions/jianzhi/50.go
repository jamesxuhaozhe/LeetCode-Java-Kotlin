package jianzhi

// Problem link: https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
// 第一次用哈希表记一下数，然后再看一次
func firstUniqChar(s string) byte {
	sMap := make(map[string]bool)
	for _, ch := range s {
		key := string(ch)
		if _, ok := sMap[key]; ok {
			sMap[key] = false
		} else {
			sMap[key] = true
		}
	}

	for _, ch := range s {
		key := string(ch)
		if sMap[key] {
			return byte(ch)
		}
	}

	return ' '
}

// 充分利用只有小写字母，用一个固定长度数组就可以，非常节省空间
func firstUniqChar1(s string) byte {
	arr := make([]int, 26)
	length := len(s)
	for i := 0; i < length; i++ {
		arr[s[i] - 'a']++
	}
	for i := 0; i < length; i++ {
		if arr[s[i] - 'a'] == 1 {
			return s[i]
		}
	}

	return ' '
}
