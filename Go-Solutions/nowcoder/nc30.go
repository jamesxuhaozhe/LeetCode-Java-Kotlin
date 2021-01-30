package nowcoder

func minNumberdisappered( arr []int ) int {
	// write code here
	if len(arr) == 0 {
		return 0
	}

	res := 1
	for i := 0; i < len(arr); i++ {
		if arr[i] <= 0 {
			continue
		} else if arr[i] <= res {
			res++
		}
	}
	return res
}
