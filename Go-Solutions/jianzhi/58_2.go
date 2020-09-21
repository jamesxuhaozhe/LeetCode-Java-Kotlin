package jianzhi

// Problem link: https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
func reverseLeftWords(s string, n int) string {
	a := s[:n]
	b := s[n:]
	return b + a
}
