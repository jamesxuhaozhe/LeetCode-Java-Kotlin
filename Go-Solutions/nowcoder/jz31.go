package nowcoder

func NumberOf1Between1AndN_Solution(n int) int {
	// write code here
	if n < 1 {
		return 0
	}

	count := 0
	for i := 1; i <= n; i++ {
		count += getOnes(i)
	}
	return count
}

func getOnes(num int) int {
	count := 0
	for num != 0 {
		if num%10 == 1 {
			count++
		}
		num /= 10
	}
	return count
}
