package newcode

func jumpFloor( number int ) int {
	// write code here
	if number == 0 || number == 1 {
		return 1
	}
	if number == 2 {
		return 2
	}
	dp := make([]int, number+1)
	dp[0], dp[1], dp[2] = 1, 1, 2
	for i := 3; i <= number; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[number]
}

func jumpFloor_better( number int ) int {
	// write code here
	if number == 0 || number == 1 {
		return 1
	}
	pre, cur := 1, 2
	for i := 3; i <= number; i++ {
		tmp := pre + cur
		pre = cur
		cur = tmp
	}
	return cur
}
