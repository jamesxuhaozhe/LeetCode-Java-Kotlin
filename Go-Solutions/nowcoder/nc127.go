package nowcoder

/**
一看到两个字符串的“最值”问题，一般想到二维dp。很自然地想到把str1前i个字符和str2前j个字符最长公共子串的长度作为dp[i][j]，但由于子串定义必须是原字符串连续的序列，这样定义无法找到递推关系，因此需要加限定条件——以str1[i-1]和str2[j-1]结尾的最长公共子串长度。
另外如果找不到这样的子串，应该return "-1"而不是返回空串
 */
func LCS127(str1 string, str2 string) string {
	// write code here
	m := len(str1)
	n := len(str2)

	// dp[i][j] 表示以 str1[i-1] 和 str2[j-1]结尾的最长公共子串长度
	dp := initDp127(m+1, n+1)
	//初始化base case
	for i := 0; i <= m; i++ {
		dp[i][0] = 0
	}
	for i := 0; i <= n; i++ {
		dp[0][i] = 0
	}

	maxLen, end := 0, 0
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if str1[i-1] == str2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = 0
			}
			if dp[i][j] > maxLen {
				maxLen = dp[i][j]
				end = j - 1
			}
		}
	}
	if maxLen == 0 {
		return "-1"
	} else {
		return str2[end+1-maxLen : end+1]
	}
}

func initDp127(m, n int) [][]int {
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	return dp
}
