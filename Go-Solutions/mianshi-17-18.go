package main

import (
	"fmt"
	"math"
)

// 自己写的答案，这道题本质上来说跟76题 最小覆盖子串是一样的，只不过76是字符，这道题是数字而已
func shortestSeq(big []int, small []int) []int {
	if big == nil || len(big) == 0 {
		return []int{}
	}

	if small == nil || len(small) == 0 {
		return []int{}
	}

	need := make(map[int]int)
	for _, value := range small {
		need[value]++
	}

	window := make(map[int]int)
	res := math.MaxInt64
	count := 0

	left, right := 0, 0
	finalLeft, finalRight := -1, -1
	for right < len(big) {
		window[big[right]]++
		if need[big[right]] > 0 && need[big[right]] >= window[big[right]] {
			count++
		}

		for count == len(small) {
			if need[big[left]] > 0 && need[big[left]] >= window[big[left]] {
				count--
			}
			if right-left+1 < res {
				res = right - left + 1
				finalLeft, finalRight = left, right
				// 因为题目的意思需要我们返回最短seq的起始index，如果有多个结果的话，需要返回最左的那个，所以这里的逻辑要用finalLeft缓存一下，如果这次的res跟上次最小的一样，
				// 需要看一下left 和 finalLeft哪个更左
			} else if right-left+1 == res {
				if left < finalLeft {
					finalLeft, finalRight = left, right
				}
			}
			window[big[left]]--
			left++
		}
		right++
	}
	// 如果finalLeft的值根本没有变化过，说明我们找不到解，直接返回空就可以了
	if finalLeft == -1 {
		return []int{}
	}
	return []int{finalLeft, finalRight}
}

func main() {
	big := []int{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}
	small := []int{1, 5, 9}
	fmt.Printf("result: %v", shortestSeq(big, small))
}
