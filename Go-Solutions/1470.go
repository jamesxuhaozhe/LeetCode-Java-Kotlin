package main

func shuffle(nums []int, n int) []int {
	ret := make([]int, 2*n)
	for i := 0; i < n; i++ {
		cur := 2 * i
		next := cur + 1
		ret[cur] = nums[i]
		ret[next] = nums[i+n]
	}
	return ret
}
