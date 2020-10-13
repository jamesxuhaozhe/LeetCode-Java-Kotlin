package main

// sol: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
// https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247486069&idx=1&sn=c81cd8228806b4f52e3206c234b2a970&chksm=fa0e65f4cd79ece20b7ac29bdc079388673f541700601826e4931678911adf31c2e8e547d56b&scene=27#wechat_redirect
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	n := len(nums1)
	m := len(nums2)
	left := (n + m + 1) / 2
	right := (n + m + 2) / 2
	return float64(getKth4(nums1, 0, n-1, nums2, 0, m-1, left)+getKth4(nums1, 0, n-1, nums2, 0, m-1, right)) / 2.0
}

func getKth4(nums1 []int, start1 int, end1 int, nums2 []int, start2 int, end2 int, k int) int {
	len1 := end1 - start1 + 1
	len2 := end2 - start2 + 1
	if len1 > len2 {
		return getKth4(nums2, start2, end2, nums1, start1, end1, k)
	}
	if len1 == 0 {
		return nums2[start2+k-1]
	}

	if k == 1 {
		return min4(nums1[start1], nums2[start2])
	}

	i := start1 + min4(len1, k/2) - 1
	j := start2 + min4(len2, k/2) - 1
	if nums1[i] > nums2[j] {
		return getKth4(nums1, start1, end1, nums2, j+1, end2, k-(j-start2+1))
	} else {
		return getKth4(nums1, i+1, end1, nums2, start2, end2, k-(i-start1+1))
	}
}

func min4(num1 int, num2 int) int {
	if num1 > num2 {
		return num2
	}
	return num1
}
