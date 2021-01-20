package nowcoder

// sol: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
/**
题目要求
O
(
l
o
g
N
)
O(logN) 的时间复杂度，基本可以断定本题是需要使用二分查找，怎么分是关键。
由于题目说数字了无重复，举个例子：
1 2 3 4 5 6 7 可以大致分为两类，
第一类 2 3 4 5 6 7 1 这种，也就是 nums[start] <= nums[mid]。此例子中就是 2 <= 5。
这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
第二类 6 7 1 2 3 4 5 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2。
这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]，则在后半部分找，否则去前半部分找。

此题有个存在重复数字的变形题，可参考 此题解

作者：reedfan
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
func search48(A []int, target int) int {
	// write code here
	if len(A) == 0 {
		return -1
	}
	left, right := 0, len(A)-1
	for left <= right {
		mid := left + (right-left)>>1
		if A[mid] == target {
			return mid
		}
		if A[mid] >= A[left] {
			if target >= A[left] && target < A[mid] {
				right = mid - 1
			} else {
				left = mid + 1
			}
		} else {
			if target >= A[mid] && target < A[right] {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
	}
	return -1
}
