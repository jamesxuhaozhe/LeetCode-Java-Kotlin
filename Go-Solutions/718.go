package main

// dp, dp[i][j] 表示A[i:]和B[j:]的最长公共子数组的长度, 如果 A[i]==B[j]的话，那么 dp[i][j]=dp[i+1][j+1] + 1,如果A[i] != B[j]，那么dp[i][j]=0
// TODO 用别的做法
func findLength(A []int, B []int) int {
	if A == nil || len(A) == 0 {
		return 0
	}

	if B == nil || len(B) == 0 {
		return 0
	}

	n, m := len(A), len(B)
	dp := make([][]int, n + 1)
	for index, _ := range dp {
		dp[index] = make([]int, m + 1)
	}
	maxAns := 0
	for i := n - 1; i >= 0; i-- {
		for j := m - 1; j >= 0; j-- {
			if A[i] == B[j] {
				dp[i][j] = dp[i+1][j+1] + 1
			} else {
				dp[i][j] = 0
			}
			maxAns = max718(maxAns, dp[i][j])
		}
	}
	return maxAns
}

func max718(num1 int, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}
