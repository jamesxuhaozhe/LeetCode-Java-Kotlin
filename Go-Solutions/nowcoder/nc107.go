package nowcoder

func solve107(a []int) int {
	// write code here
	if len(a) == 0 {
		return -1
	}
	if len(a) == 1 {
		return 0
	}
	res := -1
	isPeak := false
	for i := 0; i < len(a); i++ {
		isPeak = false
		if i == len(a)-1 {
			if a[i] >= a[i-1] {
				isPeak = true
			}
		} else if i == 0 {
			if a[i] >= a[i+1] {
				isPeak = true
			}
		} else if i-1 >= 0 && i+1 <= len(a)-1 {
			if a[i] >= a[i-1] && a[i] >= a[i+1] {
				isPeak = true
			}
		}
		if isPeak {
			res = max107(res, i)
		}
	}
	return res
}

func max107(a, b int) int {
	if a > b {
		return a
	}
	return b
}
