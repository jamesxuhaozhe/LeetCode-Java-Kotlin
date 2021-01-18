package main

func numWays(n int) int {
	if n == 0 || n == 1 {
		return 1
	}
	pre, cur := 1, 2
	for i := 3; i <= n; i++ {
		tmp := (pre + cur) % 1000000007
		pre = cur
		cur = tmp
	}
	return cur
}
