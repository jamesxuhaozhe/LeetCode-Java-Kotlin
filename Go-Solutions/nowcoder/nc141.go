package nowcoder

func judge141( str string ) bool {
	// write code here
	start, end := 0, len(str)-1
	for start < end {
		if str[start] != str[end] {
			return false
		}
		start++
		end--
	}
	return true
}
