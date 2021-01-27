package nowcoder

import "sort"

// https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
func combinationSum2(num []int, target int) [][]int {
	// write code here
	if len(num) == 0 {
		return [][]int{}
	}

	res := make([][]int, 0)
	list := make([]int, 0)
	sort.Ints(num)

	dfs46(num, &res, &list, target, 0)

	return res
}

func dfs46(num []int, res *[][]int, list *[]int, leftToTarget int, begin int) {
	if leftToTarget == 0 {
		listToAdd := make([]int, len(*list))
		for i := 0; i < len(*list); i++ {
			listToAdd[i] = (*list)[i]
		}
		*res = append(*res, listToAdd)
		return
	}

	for i := begin; i < len(num); i++ {
		if leftToTarget < num[i] {
			break
		}

		if i > begin && num[i] == num[i-1] {
			continue
		}

		*list = append(*list, num[i])
		dfs46(num, res, list, leftToTarget-num[i], i+1)
		*list = (*list)[:len(*list)-1]
	}
}
