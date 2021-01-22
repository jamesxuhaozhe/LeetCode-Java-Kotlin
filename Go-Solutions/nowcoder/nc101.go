package nowcoder

func solve101(a []int) int {
	// write code here
	n := len(a)
	expectedSum := n * (n + 1) / 2
	actualSum := 0
	for _, v := range a {
		actualSum += v
	}
	return expectedSum - actualSum
}
