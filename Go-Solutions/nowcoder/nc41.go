package nowcoder

func maxLength(arr []int) int {
	// write code here
	hm := make(map[int]int)
	left, right := 0, 0
	res := 0
	for right < len(arr) {
		if idx, ok := hm[arr[right]]; ok {
			if idx >= left {
				left = idx + 1
			}
		}
		if right-left+1 > res {
			res = right - left + 1
		}
		hm[arr[right]] = right
		right++
	}
	return res
}
