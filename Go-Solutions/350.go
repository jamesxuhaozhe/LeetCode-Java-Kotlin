package main

// 用两个数组的解发
func intersect(nums1 []int, nums2 []int) []int {
	map1 := make(map[int]int, len(nums1))
	map2 := make(map[int]int, len(nums2))
	for _, num1 := range nums1 {
		map1[num1]++
	}
	for _, num2 := range nums2 {
		map2[num2]++
	}

	// 优化一下，从长度小的map开始遍历，遍历的次数会更小一些
	if len(map1) > len(map2) {
		return getRes350(map1, map2)
	} else {
		return getRes350(map2, map1)
	}
}

func getRes350(map1, map2 map[int]int) []int {
	ans := make([]int, 0)
	for key2, value2 := range map2 {
		if count, ok := map1[key2]; ok {
			loop := min350(value2, count)
			for i := 0; i < loop; i++ {
				ans = append(ans, key2)
			}
		}
	}
	return ans
}

func min350(num1 int, num2 int) int {
	if num1 > num2 {
		return num2
	}
	return num1
}

// 用一个map也是可以实现的
func intersect_better(nums1 []int, nums2 []int) []int {
	if nums1 == nil || nums2 == nil {
		return []int{}
	}

	map1 := make(map[int]int)
	for _, value := range nums1 {
		map1[value]++
	}

	ans := make([]int, 0)
	for _, value := range nums2 {
		if count, ok := map1[value]; ok {
			if count > 0 {
				ans = append(ans, value)
				map1[value]--
			}
		}
	}
	return ans
}
