package nowcoder

func jumpFloorjz8(n int) int {
	// write code here
	if n <= 1 {
		return n
	}
	if n == 2 {
		return 2
	}
	a, b := 1, 2
	sum := 0
	for i := 2; i < n; i++ {
		sum = a + b
		a = b
		b = sum
	}
	return sum
}

func jumpFloorjz8bad(n int) int {
	if n <= 1 {
		return n
	}
	if n == 2 {
		return 2
	}
	return jumpFloorjz8bad(n-1) + jumpFloorjz8bad(n-2)
}
