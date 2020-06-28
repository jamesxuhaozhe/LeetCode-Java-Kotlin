package offer

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
