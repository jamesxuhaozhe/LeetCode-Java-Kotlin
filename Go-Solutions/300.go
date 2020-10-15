package main

// dp[i]表示以nums[i]为结尾的最长子序列的长度，必须包含nums[i]，那么对于dp[i] = max(dp[j]) + 1， 0<=j < i and nums[i] > nums[j]
// 详细请看官方题解：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
// TODO 用别的做法
func lengthOfLIS(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}

	dp := make([]int, len(nums))
	dp[0] = 1
	// 当数组只有一个元素的时候，我们默认直接返回1
	maxAns := 1
	for i := 1; i < len(nums); i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] {
				dp[i] = max300(dp[i], dp[j]+1)
			}
		}
		maxAns = max300(dp[i], maxAns)
	}
	return maxAns
}

func max300(num1 int, num2 int) int {
	if num1 > num2 {
		return num1
	}
	return num2
}
