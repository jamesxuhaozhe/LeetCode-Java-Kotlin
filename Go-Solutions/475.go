package main

import (
	"math"
	"sort"
)

// brute force solution
func findRadius(houses []int, heaters []int) int {
	if houses == nil || len(houses) == 0 {
		return -1
	}

	if heaters == nil || len(heaters) == 0 {
		return -1
	}

	ans := math.MinInt64
	for _, house := range houses {
		curDistance := math.MaxInt64
		for _, heater := range heaters {
			curDistance = min475(curDistance, abs475(heater, house))
		}
		ans = max475(ans, curDistance)
	}
	return ans
}

func min475(num1, num2 int) int {
	if num1 > num2 {
		return num2
	}
	return num1
}

//https://books.halfrost.com/leetcode/ChapterFour/0475.Heaters/
func findRadius_binary_search(houses []int, heaters []int) int {
	if houses == nil || len(houses) == 0 {
		return -1
	}

	if heaters == nil || len(heaters) == 0 {
		return -1
	}
	// 不要忘了要排序
	sort.Ints(heaters)
	ans := math.MinInt64
	for _, house := range houses {
		closestHeater := getClosetHeater(house, heaters)
		ans = max475(ans, abs475(house, closestHeater))
	}
	return ans
}

func getClosetHeater(house int, heaters []int) int {
	left, right := 0, len(heaters)-1
	if house <= heaters[left] {
		return heaters[left]
	}
	if house >= heaters[right] {
		return heaters[right]
	}

	for left <= right {
		mid := left + (right-left)>>1
		if heaters[mid] == house {
			return heaters[mid]
		} else if heaters[mid] > house {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	if abs475(house, heaters[left]) >= abs475(house, heaters[right]) {
		return heaters[right]
	}
	return heaters[left]
}

func max475(num1 int, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}

func abs475(num1, num2 int) int {
	if num1 > num2 {
		return num1 - num2
	}
	return num2 - num1
}
