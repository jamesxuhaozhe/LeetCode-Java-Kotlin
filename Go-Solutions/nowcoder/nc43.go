package nowcoder

// https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
func permute43(num []int) [][]int {
	// write code here
	if len(num) == 0 {
		return [][]int{}
	}

	res := make([][]int, 0)
	used := make([]bool, len(num))
	list := make([]int, 0)

	dfs43(num, &res, &list, used)
	return res
}

func dfs43(num []int, res *[][]int, list *[]int, used []bool) {
	if len(num) == len(*list) {
		listToAdd := make([]int, 0)
		for i := 0; i < len(*list); i++ {
			listToAdd = append(listToAdd, (*list)[i])
		}
		*res = append(*res, listToAdd)
		return
	}

	for i := 0; i < len(num); i++ {
		if !used[i] {
			*list = append(*list, num[i])
			used[i] = true

			dfs43(num, res, list, used)

			*list = (*list)[:len(*list)-1]
			used[i] = false
		}
	}
}
