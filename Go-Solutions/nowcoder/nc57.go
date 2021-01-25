package nowcoder

func reverse57(x int) int {
	// write code here
	ans, f := 0, 1
	if x < 0 {
		f = -1
		x = -x
	}
	for x > 0 {
		ans = ans*10 + x%10
		x /= 10
	}
	return ans * f
}
