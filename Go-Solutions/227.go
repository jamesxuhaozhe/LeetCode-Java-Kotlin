package main

func solution(knows func(a int, b int) bool) func(n int) int {
	return func(n int) int {
		if n == 1 {
			return 0
		}
		for i := 0; i < n; i++ {
			find := true
			for j := 0; j < n; j++ {
				if i != j {
					if knows(i, j) || !knows(j, i) {
						find = false
						break
					}
				}
			}
			if find {
				return i
			}
		}
		return -1
	}
}
