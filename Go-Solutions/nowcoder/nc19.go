package nowcoder

// https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
func maxsumofSubarray19( arr []int ) int {
	// write code here
	if arr == nil || len(arr) == 0 {
		return 0
	}
	pre := 0
	maxAns := arr[0]
	for _, v := range arr {
		pre = max19(pre+v, v)
		maxAns = max19(maxAns, pre)
	}
	return maxAns
}

func max19(a, b int) int {
	if a > b {
		return a
	}
	return b
}