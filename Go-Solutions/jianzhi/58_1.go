package jianzhi

import "strings"

// Problem link: https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
// TODO 用two pointers来做
func reverseWords(s string) string {
	res := ""
	slice := strings.Fields(s)
	for i := len(slice) - 1; i >= 0; i-- {
		if i != 0 {
			res += slice[i] + " "
		} else {
			res += slice[i]
		}
	}
	return res
}
