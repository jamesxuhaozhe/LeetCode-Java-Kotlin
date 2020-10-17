package main

import (
	"sort"
)

func hIndex(citations []int) int {
	if citations == nil || len(citations) == 0 {
		return 0
	}

	n := len(citations)
	sort.Ints(citations)
	low, high := 1, n
	for low <= high {

		mid := low + (high - low) >> 1
		count := getGreaterOrEqualElementsCount(mid, citations)
		if mid <= count {
			if mid == n || (getGreaterOrEqualElementsCount(mid + 1, citations) < mid + 1) {
				return mid
			}
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return 0
}

func getGreaterOrEqualElementsCount(h int, citations []int) int {
	//if h <= citations[0] {
	//	return len(citations)
	//}
	//return len(citations) - getLastLessElementIdx(h, citations)
	count := 0
	for _, value := range citations {
		if value >= h {
			count++
		}
	}
	return count
}

func getLastLessElementIdx(h int, citations []int) int {
	low, high := 0, len(citations) - 1
	for low <= high {
		mid := low + (high - low) >> 1
		if citations[mid] <= h {
			if (mid == len(citations) - 1) || (citations[mid + 1] > h) {
				return mid
			}
			low = mid + 1
		} else {
			high = mid - 1
		}
	}
	return -1
}
//
//func main() {
//	arr := []int{1,2}
//	fmt.Println(hIndex(arr))
//}
