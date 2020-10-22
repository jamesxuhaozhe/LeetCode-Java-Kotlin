package main

import "math"

/*
本题与424. 替换后的最长重复字符一样的套路，不过更为简单一点，直接用count统计窗口内的0的个数。当窗口内0的个数大于K时，我们需要缩小窗口；当窗口内0的个数小于等于k时，我们就可将窗口大小来与result来进行比较来确定是否更新result了。

注：窗口内0的个数就是表示可以被1替换的个数！

作者：xiaoneng
链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/hua-dong-chuang-kou-de-chang-gui-jie-fa-by-xiaonen/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
func longestOnes(A []int, K int) int {
	if A == nil || len(A) == 0 {
		return 0
	}
	if K >= len(A) {
		return len(A)
	}

	// 记录窗口中0的个数
	count := 0
	res := math.MinInt64
	left, right := 0, 0
	for right < len(A) {
		if A[right] == 0 {
			count++
		}
		for count > K {
			if A[left] == 0 {
				count--
			}
			left++
		}
		res = max1004(res, right-left+1)
		right++
	}
	return res
}

func max1004(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
