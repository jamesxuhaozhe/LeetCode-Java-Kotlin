package main

//https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
func findDuplicate(nums []int) int {
	slow := 0
	fast := 0
	slow = nums[slow]
	fast = nums[nums[fast]]
	for slow != fast {
		slow = nums[slow]
		fast = nums[nums[fast]]
	}

	walker := 0
	for walker != slow {
		walker = nums[walker]
		slow = nums[slow]
	}

	return walker
}

// https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
// https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
func findDuplicate1(nums []int) int {
	n := len(nums)
	l, r := 1, n - 1
	ans := -1
	for l <= r {
		mid := l + (r - l) >> 1

		cnt := 0
		for i := 0; i < n; i++ {
			if nums[i] <= mid {
				cnt++
			}
		}
		if cnt <= mid {
			l = mid + 1
		} else {
			r = mid - 1
			ans = mid
		}
	}
	return ans
}