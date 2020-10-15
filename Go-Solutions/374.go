package main

// nothing fancy, just binary search
func guessNumber(n int) int {
	left, right := 1, n
	for left <= right {
		mid := left + (right-left)>>1
		if guess(mid) == 0 {
			return mid
		} else if guess(mid) == 1 {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return -1
}

func guess(mid int) int {
	return 0
}
