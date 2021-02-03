package nowcoder

func FirstNotRepeatingChar(str string) int {
	// write code here
	if len(str) == 0 {
		return -1
	}

	hashTime := [256]uint8{}
	for i := 0; i < len(str); i++ {
		hashTime[str[i]]++
	}
	for j := 0; j < len(str); j++ {
		if hashTime[str[j]] == 1 {
			return j
		}
	}
	return -1
}
