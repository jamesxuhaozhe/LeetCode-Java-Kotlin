package main

func isPerfectSquare(num int) bool {
	sqrt := sqrt367(num)
	return sqrt*sqrt == num
}

// 牛顿迭代法
func sqrt367(num int) int {
	r := num
	for r*r > num {
		r = (r + num/r) / 2
	}
	return r

}
