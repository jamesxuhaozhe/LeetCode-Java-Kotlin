package nowcoder

import "sort"

// https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
func permuteUnique42(num []int) [][]int {
	// write code here
	if len(num) == 0 {
		return [][]int{}
	}

	res := make([][]int, 0)
	list := make([]int, 0)
	used := make([]bool, len(num))

	sort.Ints(num)

	dfs42(num, &res, &list, used)

	return res
}

func dfs42(num []int, res *[][]int, list *[]int, used []bool) {
	if len(num) == len(*list) {
		listToAdd := make([]int, 0)
		for i := 0; i < len(*list); i++ {
			listToAdd = append(listToAdd, (*list)[i])
		}
		*res = append(*res, listToAdd)
		return
	}

	for i := 0; i < len(num); i++ {
		if used[i] {
			continue
		}

		if i > 0 && num[i] == num[i-1] && !used[i-1] {
			continue
		}

		*list = append(*list, num[i])
		used[i] = true

		dfs42(num, res, list, used)

		*list = (*list)[:len(*list)-1]
		used[i] = false
	}
}
