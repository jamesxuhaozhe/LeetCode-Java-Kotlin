package main

// just like 34, search the far left index
func firstBadVersion(n int) int {

	left, right := 1, n
	for left <= right {
		mid := left + (right - left) >> 1
		if !isBadVersion(mid) {
			left = mid + 1
		} else {
			if (mid == 1) || !isBadVersion(mid - 1) {
				return mid
			}
			right = mid - 1
		}
	}
	return -1
}

func isBadVersion(n int) bool {
	return false
}