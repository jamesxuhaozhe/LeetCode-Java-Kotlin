package main

// this is brute force, it times out in the oj, but we propose it first
func fourSumCount(A []int, B []int, C []int, D []int) int {
	if A == nil || B == nil || C == nil || D == nil {
		return 0
	}

	count := 0
	for _, a := range A {
		for _, b := range B {
			for _, c := range C {
				for _, d := range D {
					if a + b + c + d == 0 {
						count++
					}
				}
			}
		}
	}

	return count
}

// https://leetcode-cn.com/problems/4sum-ii/solution/ji-ge-xiao-xi-jie-ji-hu-shuang-bai-by-cluas/
func fourSumCount_smart(A []int, B []int, C []int, D []int) int {
	map1 := make(map[int]int, len(A)* len(B))
	for _, a := range A {
		for _, b := range B {
			map1[a + b]++
		}
	}

	ans := 0
	for _, c :=range C {
		for _, d := range D {
			if count, ok := map1[-c-d]; ok {
				ans+=count
			}
		}
	}
	return ans
}
