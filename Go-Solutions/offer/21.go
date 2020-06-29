package offer

func exchange(nums []int) []int {
	if nums == nil || len(nums) == 0 {
		return nums
	}
	n := len(nums)
	result := make([]int, n)
	left := 0
	right := n - 1
	for i := 0; i < n; i++ {
		if nums[i] % 2 == 1 {
			result[left] = nums[i]
			left++
		} else {
			result[right] = nums[i]
			right--
		}
	}
	return result
}
