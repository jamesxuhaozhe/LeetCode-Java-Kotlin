package nowcoder

func minPathSum59(matrix [][]int) int {
	// write code here
	if matrix == nil {
		return 0
	}
	m := len(matrix)
	if m < 1 {
		return 0
	}

	n := len(matrix[0])
	if n < 1 {
		return 0
	}

	dp := getDp59(m, n)

	dp[0][0] = matrix[0][0]
	for i := 1; i < n; i++ {
		dp[0][i] = dp[0][i-1] + matrix[0][i]
	}
	for i := 1; i < m; i++ {
		dp[i][0] = dp[i-1][0] + matrix[i][0]
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if i == 0 || j == 0 {
				continue
			} else {
				dp[i][j] = min59(dp[i][j-1], dp[i-1][j]) + matrix[i][j]
			}
		}
	}
	return dp[m-1][n-1]
}

func min59(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func getDp59(m, n int) [][]int {
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	return dp
}
