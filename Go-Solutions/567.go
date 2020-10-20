package main

// stupid solution
func checkInclusion(s1 string, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}

	s1Len, s2Len := len(s1), len(s2)
	s1Flag := make([]int, 26)
	for i := 0; i < s1Len; i++ {
		s1Flag[s1[i]-'a']++
	}

	for i := 0; i < s2Len-s1Len+1; i++ {
		strToCheck := s2[i : i+s1Len]
		flag := calculate567(strToCheck)
		if isOk567(flag, s1Flag) {
			return true
		}
	}
	return false
}

func calculate567(check string) []int {
	result := make([]int, 26)
	for i := 0; i < len(check); i++ {
		result[check[i]-'a']++
	}
	return result
}

// 实在前面算法上的优化，其实只需要一个s2Flag就可以了，每次循环的时候进行维护
func checkInclusion_sliding_window(s1 string, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}

	s1Len, s2Len := len(s1), len(s2)
	s1Flag := make([]int, 26)
	s2Flag := make([]int, 26)
	for i := 0; i < s1Len; i++ {
		s1Flag[s1[i]-'a']++
		s2Flag[s2[i]-'a']++
	}

	for i := 0; i < s2Len-s1Len; i++ {
		if isOk567(s1Flag, s2Flag) {
			return true
		}
		//统计下一个要进入的字符次数
		s2Flag[s2[i+s1Len]-'a']++
		//要移除窗口的字符次数要减少
		s2Flag[s2[i]-'a']--
	}
	return isOk567(s1Flag, s2Flag)
}

func isOk567(flag1 []int, flag2 []int) bool {
	for i := 0; i < len(flag1); i++ {
		if flag1[i] != flag2[i] {
			return false
		}
	}
	return true
}

//func main() {
//	s1 := "ab"
//	s2 := "eidboaoo"
//
//	fmt.Println(checkInclusion_sliding_window(s1, s2))
//}
