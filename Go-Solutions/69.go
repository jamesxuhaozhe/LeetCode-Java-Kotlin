package main

import "fmt"

func mySqrt(x int) int {
	if x == 0 {
		return 0
	}

	low, high, res := 1, x, 0
	for low <= high {
		mid := low + (high-low)>>1
		if mid == x/mid {
			return mid
		} else if mid < x/mid {
			// 如果从来没有从上面那个return出去的话，也就是说循环过后，没有哪个mid，mid*mid后正好可以等于x，那么也要把最后一次最接近的一个答案保存起来, 比如，当x是2 或 3， 6， 8， 14， 13， 12.。。。
			low = mid + 1
			res = mid
		} else {
			high = mid - 1
		}
	}
	fmt.Printf("x: %d, res: %d\n", x, res)
	return res
}

//func main() {
//	fmt.Println(mySqrt(2))
//
//	//for i:= 0; i < 10000; i++ {
//	//	mySqrt(i)
//	//}
//}

// https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
func mySqrt_newton(x int) int {
	r := x
	for r * r > x {
		r = (r + x / r) / 2
	}
	return r
}
