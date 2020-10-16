package main

// https://leetcode-cn.com/problems/is-subsequence/solution/pan-duan-zi-xu-lie-by-leetcode-solution/
// greedy
func isSubsequence(s string, t string) bool {
	n, m, i, j := len(s), len(t), 0, 0
	for i < n && j < m {
		if s[i] == t[j] {
			i++
		}
		j++
	}
	return i == n
}
