package nowcoder

// //https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
func generateParenthesis(n int) []string {
	// write code here
	if n < 1 {
		return []string{}
	}

	res := make([]string, 0)
	dfs("", n, n, &res)
	return res
}

func dfs(str string, left, right int, res *[]string) {
	if left == 0 && right == 0 {
		*res = append(*res, str)
		return
	}

	if left > right {
		return
	}

	if left > 0 {
		dfs(str+"(", left-1, right, res)
	}

	if right > 0 {
		dfs(str+")", left, right-1, res)
	}
}
