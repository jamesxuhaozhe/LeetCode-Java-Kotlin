package nowcoder

func IsPopOrder(pushV []int, popV []int) bool {
	// write code here
	if pushV == nil || popV == nil {
		return false
	}
	if len(pushV) != len(popV) {
		return false
	}

	stack := make([]int, 0)
	j := 0
	for i := 0; i < len(pushV); i++ {
		stack = append(stack, pushV[i])
		for len(stack) != 0 && stack[len(stack)-1] == popV[j] {
			stack = stack[:len(stack)-1]
			j++
		}
	}
	return len(stack) == 0
}
