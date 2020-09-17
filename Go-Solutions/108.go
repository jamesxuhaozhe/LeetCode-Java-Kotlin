package main

// Problem link: https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
// just recursion by definition
func sortedArrayToBST(nums []int) *TreeNode {
	if nums == nil || len(nums) == 0 {
		return nil
	}

	return &TreeNode{
		Val:   nums[len(nums)/2],
		Left:  sortedArrayToBST(nums[:len(nums)/2]),
		Right: sortedArrayToBST(nums[len(nums)/2+1:]),
	}
}


func sortedArrayToBST1(nums []int) *TreeNode {
	if nums == nil || len(nums) == 0 {
		return nil
	}

	return createBST108(nums, 0, len(nums) - 1)
}

func createBST108(nums []int, start int, end int) *TreeNode {
	if start > end {
		return nil
	}
	
	mid := (start + end) / 2
	return &TreeNode{
		Val:   nums[mid],
		Left:  createBST108(nums, start, mid-1),
		Right: createBST108(nums, mid+1, end),
	}
}
