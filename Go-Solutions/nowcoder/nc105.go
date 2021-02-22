package nowcoder

func upper_bound_(n int, v int, a []int) int {
	// write code here
	left, right := 0, n-1
	for left <= right {
		mid := left + (right-left)>>1
		// 如果 小于 目标值，说明left还要往右
		if a[mid] < v {
			left = mid + 1
		} else {
			// 如果当前的a[mid]已经>=目标值，并且mid已经是最左了，或者前面一个数就已经小于目标值了，说明当前的mid+1就是结果
			if (mid == 0) || (a[mid-1] < v) {
				return mid + 1
			}
			right = mid - 1
		}
	}
	return n + 1
}
