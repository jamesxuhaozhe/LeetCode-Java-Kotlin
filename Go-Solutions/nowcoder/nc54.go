package nowcoder

import "sort"

// TODO: use java
func threeSum(num []int) [][]int {
	// write code here
	if len(num) == 0 {
		return [][]int{}
	}
	sort.Ints(num)
	res := make([][]int, 0)
	for i := 0; i < len(num); i++ {
		tuples := twoSum54(num, i+1, 0-num[i])
		for j := 0; j < len(tuples); j++ {
			tempRes := []int{num[i], tuples[j][0], tuples[j][1]}
			res = append(res, tempRes)
		}
		for i < len(num)-1 && num[i] == num[i+1] {
			i++
		}
	}
	return res
}

func twoSum54(num []int, start int, target int) [][]int {
	res := make([][]int, 0)
	low, high := start, len(num)-1
	for low < high {
		left, right := num[low], num[high]
		sum := left + right
		if target < sum {
			for low < high && num[high] == right {
				high--
			}
		} else if sum < target {
			for low < high && num[low] == left {
				low++
			}
		} else {
			res = append(res, []int{left, right})
			for low < high && num[low] == left {
				low++
			}
			for low < high && num[high] == right {
				right--
			}
		}
	}
	return res
}
