package nowcoder

func solve103( str string ) string {
	// write code here
	if len(str) == 0 {
		return str
	}

	runes := []rune(str)

	start, end := 0, len(runes)-1
	for start < end {
		runes[start], runes[end] = runes[end], runes[start]
		start++
		end--
	}
	return string(runes)
}
