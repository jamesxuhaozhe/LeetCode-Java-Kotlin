package main

import (
	"math"
	"sort"
)

// normal brute force
func findRightInterval(intervals [][]int) []int {
	if intervals == nil || len(intervals) == 0 {
		return nil
	}

	res := make([]int, len(intervals))
	for i, intervali := range intervals {
		cur := intervali[1]
		lastMinIdx := -1
		minValue := math.MaxInt64
		for j, intervalj := range intervals {
			if intervalj[0] >= cur && intervalj[0] < minValue {
				minValue = intervalj[0]
				lastMinIdx = j
			}
		}
		res[i] = lastMinIdx
	}
	return res
}

type Interval struct {
	start int
	end   int
}

type IntervalList []Interval

func (in IntervalList) Len() int {
	return len(in)
}

func (in IntervalList) Less(i, j int) bool {
	return in[i].start <= in[j].start
}

func (in IntervalList) Swap(i, j int) {
	in[i], in[j] = in[j], in[i]
}

func findRightInterval_binarySearch(intervals [][]int) []int {
	if intervals == nil || len(intervals) == 0 {
		return nil
	}
	res := make([]int, len(intervals))
	intervalList := make([]Interval, 0)
	intervalMap := make(map[Interval]int)

	for index, interval := range intervals {
		intervalList = append(intervalList, Interval{
			start: interval[0],
			end:   interval[1],
		})
		intervalMap[Interval{
			start: interval[0],
			end:   interval[1],
		}] = index
	}

	sort.Sort(IntervalList(intervalList))
	for _, interval := range intervalList {
		curNum := interval.end
		tmpIdx := getFirstGreaterOrEqualIdx(intervalList, curNum)
		if tmpIdx == -1 {
			res[intervalMap[interval]] = -1
		} else {
			res[intervalMap[interval]] = intervalMap[intervalList[tmpIdx]]
		}
	}
	return res
}

func getFirstGreaterOrEqualIdx(list []Interval, target int) int {
	low, high := 0, len(list)-1
	for low <= high {
		mid := low + (high-low)>>1
		if target <= list[mid].start {
			if (mid == 0) || (list[mid-1].start < target) {
				return mid
			}
			high = mid - 1
		} else {
			low = mid + 1
		}
	}
	return -1
}
