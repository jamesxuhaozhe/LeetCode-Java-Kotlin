package main

func nextPermutation(nums []int) {
	if len(nums) <= 1 {
		return
	}

	i := len(nums) - 2
	for i >= 0 && nums[i] >= nums[i+1] {
		i--
	}
	if i >= 0 {
		j := len(nums) - 1
		for j >= 0 && nums[j] <= nums[i] {
			j--
		}
		swap(nums, i, j)
	}
	reverse(nums, i+1)
}

func reverse(nums []int, start int) {
	end := len(nums) - 1
	for start < end {
		swap(nums, start, end)
		start++
		end--
	}
}

func swap(nums []int, i int, j int) {
	tmp := nums[j]
	nums[j] = nums[i]
	nums[i] = tmp
}
