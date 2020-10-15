package main

/**
解题思路：

本题是需要使用二分查找，怎么分是关键，举个例子：
第一类
10111
10111 和
11101
11101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
第二类
2
2
3
3
4
4
5
5
6
6
7
7
1
1 这种，也就是 nums[start] < nums[mid]。此例子中就是 2 < 5；
这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
第三类
6
6
7
7
1
1
2
2
3
3
4
4
5
5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找。

作者：reedfan
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/zai-javazhong-ji-bai-liao-100de-yong-hu-by-reedfan/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
func search81(nums []int, target int) bool {
	if nums == nil || len(nums) == 0 {
		return false
	}

	left, right := 0, len(nums)-1
	for left <= right {
		mid := left + (right-left)>>1
		if nums[mid] == target {
			return true
		}

		if nums[mid] == nums[left] {
			left++
			continue
		}

		if nums[mid] > nums[left] {
			if target >= nums[left] && target < nums[mid] {
				right = mid - 1
			} else {
				left = left + 1
			}
		} else {
			if target > nums[mid] && target <= nums[right] {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
	}
	return false
}
