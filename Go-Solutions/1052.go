package main

import (
	"math"
)

// this is a naive solution, essentially brute force solution, will time out
func maxSatisfied(customers []int, grumpy []int, X int) int {
	if customers == nil || len(customers) == 0 {
		return 0
	}

	if grumpy == nil || len(grumpy) == 0 {
		return 0
	}

	if len(customers) != len(grumpy) {
		return 0
	}

	if X > len(customers) {
		return 0
	}
	// above is special case

	max := 0
	for i := 0; i < len(customers)-X+1; i++ {
		calmStart, calmEnd := i, i+X-1
		num := totalNum(customers, grumpy, calmStart, calmEnd)
		max = max1052(max, num)
	}
	return max
}

func totalNum(customers []int, grumpy []int, start int, end int) int {
	count := 0
	for i := 0; i < len(customers); i++ {
		if i >= start && i <= end {
			count += customers[i]
		} else if grumpy[i] == 0 {
			count += customers[i]
		}
	}
	return count
}




func maxSatisfied_sliding_window(customers []int, grumpy []int, X int) int {
	if customers == nil || len(customers) == 0 {
		return 0
	}

	if grumpy == nil || len(grumpy) == 0 {
		return 0
	}

	if len(customers) != len(grumpy) {
		return 0
	}

	if X > len(customers) {
		return 0
	}

	// 加入老板不采用必杀技的话，他应该有的人流量
	baseCount := 0
	for i := 0; i < len(customers); i++ {
		if grumpy[i] == 0 {
			baseCount += customers[i]
		}
	}

	left, right := 0, 0
	max := math.MinInt64
	for ; right < len(customers); right++ {
		if grumpy[right] == 1 {
			baseCount += customers[right]
		}
		if right - X + 1 > 0 {
			if grumpy[left] == 1 {
				baseCount -= customers[left]
			}
			left++
		}

		//fmt.Printf("left: %d, right: %d, length: %d\n", left, right, right - left + 1)
		max = max1052(max, baseCount)
		//fmt.Printf("index: %d currentMax: %d\n", right, max)
	}
	return max
}


func maxSatisfied_sliding_window_while(customers []int, grumpy []int, X int) int {
	if customers == nil || len(customers) == 0 {
		return 0
	}

	if grumpy == nil || len(grumpy) == 0 {
		return 0
	}

	if len(customers) != len(grumpy) {
		return 0
	}

	if X > len(customers) {
		return 0
	}

	// 加入老板不采用必杀技的话，他应该有的人流量
	baseCount := 0
	for i := 0; i < len(customers); i++ {
		if grumpy[i] == 0 {
			baseCount += customers[i]
		}
	}

	left, right := 0, 0
	max := math.MinInt64
	for right < len(customers) {
		if grumpy[right] == 1 {
			baseCount += customers[right]
		}

		if right - left == X {
			if grumpy[left] == 1 {
				baseCount -= customers[left]
			}
			left++
		}
		//fmt.Printf("left: %d, right: %d, length: %d\n", left, right, right - left + 1)
		right++
		max = max1052(max, baseCount)
	}

	return max
}
func max1052(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
//
//
//func main() {
//	cus := []int{1,0,1,2,1,1,7,5}
//	grump := []int{0,1,0,1,0,1,0,1}
//	X := 3
//	fmt.Println(maxSatisfied_sliding_window_while(cus, grump, X))
//}
