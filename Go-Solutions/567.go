package main

// stupid solution
func checkInclusion(s1 string, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}

	s1Len, s2Len := len(s1), len(s2)
	s1Flag := make([]int, 26)
	for i := 0; i < s1Len; i++ {
		s1Flag[s1[i] - 'a']++
	}

	for i := 0; i < s2Len - s1Len + 1; i++ {
		strToCheck := s2[i:i + s1Len]
		flag := calculate567(strToCheck)
		if isOk567(flag, s1Flag) {
			return true
		}
	}
	return false
}

func isOk567(flag1 []int, flag2 []int) bool {
	for i := 0; i < len(flag1); i++ {
		if flag1[i] != flag2[i] {
			return false
		}
	}
	return true
}

func calculate567(check string) []int {
	result := make([]int, 26)
	for i := 0; i < len(check); i++ {
		result[check[i] - 'a']++
	}
	return result
}

//func main() {
//	s1 := "ab"
//	s2 := "baoo"
//
//	fmt.Println(checkInclusion(s1, s2))
//}
