package main

import (
	"math"
)
// 标准的slide window
// right 指针一直往前进，知道cost刚好超过maxcost位置，这个时候移动left，使得cost又满足条件，
// 需要维护的是cost本身，新的元素进入窗口，需要计算新元素的cost，当有元素移除window的时候，需要把他的cost移除
// 当不存在解的时候，需要返回1, 自己做出来的
func equalSubstring(s string, t string, maxCost int) int {
	if len(s) == len(t) && len(s) == 0 {
		return 0
	}

	left, right := 0, 0
	res := math.MinInt64
	cost := 0
	for right < len(s) {
		if cost <= maxCost {
			cost += getCost1208(s, t, right)
			right++
		}

		for cost > maxCost {
			cost -= getCost1208(s, t, left)
			//fmt.Printf("right: %d, left: %d\n", right, left)
			left++
		}
		res = max1208(res, right - left)
	}
	if res == math.MinInt64 {
		return 1
	}
	return res
}

func max1208(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func getCost1208(s, t string, i int) int {
	si := s[i]
	ti := t[i]
	if si > ti {
		return int(si - ti)
	}
	return int(ti - si)
}

/*func main() {
	s := "krrgw"
	t := "zjxss"

	//for i, _ := range s {
	//	fmt.Println(getCost1208(s, t, i))
	//}

	fmt.Println(equalSubstring(s, t, 19))
}*/
