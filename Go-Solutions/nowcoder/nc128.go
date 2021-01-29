package nowcoder

// see blue book
func maxWater128(arr []int) int64 {
	// write code here
	if len(arr) == 0 {
		return 0
	}

	left, right := 0, len(arr)-1
	lMax, rMax := arr[left], arr[right]
	ans := 0
	for left <= right {
		lMax = max128(lMax, arr[left])
		rMax = max128(rMax, arr[right])

		if lMax < rMax {
			ans += lMax - arr[left]
			left++
		} else {
			ans += rMax - arr[right]
			right--
		}
	}
	return int64(ans)
}

func max128(a, b int) int {
	if a > b {
		return a
	}
	return b
}
