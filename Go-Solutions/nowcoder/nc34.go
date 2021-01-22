package nowcoder

func uniquePaths(m int, n int) int {
	// write code here
	if m == 0 || n == 0 {
		return 0
	}

	if m == 1 || n == 1 {
		return 1
	}

	dp := getDpArray34(m, n)
	for i := 0; i < n; i++ {
		dp[0][i] = 1
	}
	for i := 0; i < m; i++ {
		dp[i][0] = 1
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == 0 || j == 0 {
				continue
			}
			dp[i][j] = dp[i][j-1] + dp[i-1][j]
		}
	}
	return dp[m-1][n-1]
}

func getDpArray34(m, n int) [][]int {
	arr := make([][]int, m)
	for i := 0; i < len(arr); i++ {
		arr[i] = make([]int, n)
	}
	return arr
}
