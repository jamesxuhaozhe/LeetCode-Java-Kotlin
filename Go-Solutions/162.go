package main

func findPeakElement(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return -1
	}

	if len(nums) == 1 {
		return 0
	}
	for idx, value := range nums {
		if idx == 0 && value > nums[1] {
			return 0
		}
		if idx == len(nums)-1 && value > nums[idx-1] {
			return idx
		}
		if idx-1 >= 0 && idx+1 < len(nums) && value > nums[idx+1] && value > nums[idx-1] {
			return idx
		}
	}
	return -1
}

/**
思路
标签：二分查找
过程：
首先要注意题目条件，在题目描述中出现了 nums[-1] = nums[n] = -∞，这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
根据上述结论，我们就可以使用二分查找找到峰值
查找时，左指针 l，右指针 r，以其保持左右顺序为循环条件
根据左右指针计算中间位置 m，并比较 m 与 m+1 的值，如果 m 较大，则左侧存在峰值，r = m，如果 m + 1 较大，则右侧存在峰值，l = m + 1
时间复杂度：O(logN)O(logN)

作者：guanpengchn
链接：https://leetcode-cn.com/problems/find-peak-element/solution/hua-jie-suan-fa-162-xun-zhao-feng-zhi-by-guanpengc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
func findPeakElement_1(nums []int) int {
	low, high := 0, len(nums)-1
	for low < high {
		mid := low + (high-low)>>1
		// 如果 mid 较大，则左侧存在峰值，high = m，如果 mid + 1 较大，则右侧存在峰值，low = mid + 1
		if nums[mid] > nums[mid+1] {
			high = mid
		} else {
			low = mid + 1
		}
	}
	return low
}
