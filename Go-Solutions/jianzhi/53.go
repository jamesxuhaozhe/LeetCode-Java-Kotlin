package jianzhi

func missingNumber(nums []int) int {
	n := len(nums) + 1
	last := n - 1
	expected := last * n / 2
	actual := 0
	for _, value := range nums {
		actual += value
	}
	return expected - actual
}

func missingNumber1(nums []int) int {
	i, j := 0, len(nums) - 1
	for i <= j {
		m := (i + j) / 2
		if nums[m] == m {
			i = m + 1
		} else {
			j = m - 1
		}
	}
	return i
}
