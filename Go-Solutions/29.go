package main

import (
	"fmt"
	"math"
)

/**
这一题可以用二分搜索来做。要求除法运算之后的商，把商作为要搜索的目标。
商的取值范围是 [0, dividend]，所以从 0 到被除数之间搜索。利用二分，找到(商 + 1 ) * 除数 > 被除数并且 商 * 除数 ≤ 被除数 或者 (商+1)* 除数 ≥ 被除数并且商 * 除数 < 被除数的时候，就算找到了商，
其余情况继续二分即可。最后还要注意符号和题目规定的 Int32 取值范围。
https://books.halfrost.com/leetcode/ChapterFour/0029.Divide-Two-Integers/
 */
func divide(dividend int, divisor int) int {
	sign, res := -1, 0

	if dividend == 0 {
		return 0
	}

	if divisor == 1 {
		return dividend
	}

	if dividend == math.MinInt32 && divisor == -1 {
		return math.MaxInt32
	}

	// 如果符号一样，则是正的
	if dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 {
		sign = 1
	}

	if dividend > math.MaxInt32 {
		dividend = math.MaxInt32
	}

	low, high := 0, abs29(dividend)
	for low <= high {
		quo := low + (high-low)>>1
		if (quo+1)*abs29(divisor) == abs29(dividend) {
			res = quo + 1
			break
		}
		if ((quo+1)*abs29(divisor) >= abs29(dividend) && quo*abs29(divisor) < abs29(dividend)) || ((quo+1)*abs29(divisor) > abs29(dividend) && quo*abs29(divisor) <= abs29(dividend)) {
			res = quo
			break
		}
		if (quo+1)*abs29(divisor) > abs29(dividend) && quo*abs29(divisor) > abs29(dividend) {
			high = quo - 1
		}
		if (quo+1)*abs29(divisor) < abs29(dividend) && quo*abs29(divisor) < abs29(dividend) {
			low = quo + 1
		}
	}

	if res > math.MaxInt32 {
		return sign * math.MaxInt32
	}

	if res < math.MinInt32 {
		return sign * math.MaxInt32
	}

	return sign * res
}

func abs29(val int) int {
	if val < 0 {
		return -val
	}
	return val
}

func main() {
	fmt.Println(divide(2, 2))
}
