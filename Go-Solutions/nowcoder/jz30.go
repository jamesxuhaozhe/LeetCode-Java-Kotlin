package nowcoder


// see java sol
func FindGreatestSumOfSubArray( array []int ) int {
	// write code here
	if len(array) == 0 {
		return 0
	}

	dp := make([]int, len(array)+1)
	dp[0] = 0
	max := array[0]
	for i := 1; i <= len(array); i++ {
		dp[i] = max30(array[i-1], dp[i-1]+array[i-1])
		max = max30(max, dp[i])
	}
	return max
}

func max30(a, b int) int {
	if a > b {
		return a
	}
	return b
}
