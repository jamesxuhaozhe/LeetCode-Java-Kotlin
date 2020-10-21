package main

func twoSum(nums []int, target int) []int {
	i := 0
	j := len(nums) - 1
	for i < j {
		s := nums[i] + nums[j]
		if s < target {
			i++
		} else if s > target {
			j--
		} else {
			return []int{nums[i], nums[j]}
		}
	}
	return nil
}
