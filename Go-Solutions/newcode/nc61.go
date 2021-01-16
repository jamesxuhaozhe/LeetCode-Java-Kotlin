package newcode

func twoSum(numbers []int, target int) []int {
	// write code here
	helperMap := make(map[int]int, len(numbers))
	for i, v := range numbers {
		complement := target - v
		if idx, ok := helperMap[complement]; ok && (idx != i) {
			return []int{idx + 1, i + 1}
		}
		helperMap[v] = i
	}
	return nil
}
