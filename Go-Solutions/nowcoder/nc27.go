package nowcoder

func subsets(num []int) [][]int {
	// write code here
	if len(num) == 0 {
		return [][]int{}
	}

	res := make([][]int, 0)
	list := make([]int, 0)
	dfs27(num, &res, &list, 0)

	return res
}

func dfs27(num []int, res *[][]int, list *[]int, begin int) {
	listToAdd := make([]int, len(*list))
	for i := 0; i < len(*list); i++ {
		listToAdd[i] = (*list)[i]
	}
	*res = append(*res, listToAdd)
	for i := begin; i < len(num); i++ {
		*list = append(*list, num[i])
		dfs27(num, res, list, i+1)
		*list = (*list)[:len(*list)-1]
	}
}
