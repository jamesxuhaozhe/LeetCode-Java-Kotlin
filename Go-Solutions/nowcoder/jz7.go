package nowcoder

func Fibonaccijz7(n int) int {
	// write code here
	if n <= 1 {
		return n
	}
	if n == 2 {
		return 1
	}

	return Fibonaccijz7(n-1) + Fibonaccijz7(n-2)
}

func Fibonaccijz7better(n int) int {
	// write code here
	// write code here
	if n <= 1 {
		return n
	}

	if n == 2 {
		return 1
	}

	a, b := 1, 1
	sum := 0
	for i := 2; i < n; i++ {
		sum = a + b
		a = b
		b = sum
	}
	return sum
}
