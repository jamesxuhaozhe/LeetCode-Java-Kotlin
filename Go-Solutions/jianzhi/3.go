package jianzhi

// Problem link: https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
// O n
func findRepeatNumber(nums []int) int {
	for i := 0; i < len(nums); i++ {
		for nums[i] != i {
			if nums[i] == nums[nums[i]] {
				return nums[i]
			}

			m := nums[i]
			nums[i], nums[m] = nums[m], nums[i]
		}
	}

	return -1
}

