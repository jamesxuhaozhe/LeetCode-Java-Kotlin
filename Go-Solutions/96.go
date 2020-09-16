package main

// Problem link: https://leetcode-cn.com/problems/unique-binary-search-trees/
/**
给出 n，要求利用 1-n 这些数字组成二叉排序树，有多少种不同的树的形态，输出这个个数。
这题的解题思路是 DP。dp[n] 代表 1-n 个数能组成多少个不同的二叉排序树，F(i,n) 代表以 i 为根节点，1-n 个数组成的二叉排序树的不同的个数。由于题意，我们可以得到这个等式：dp[n] = F(1,n) + F(2,n) + F(3,n) + …… + F(n,n) 。初始值 dp[0] = 1，dp[1] = 1。分析 dp 和 F(i,n) 的关系又可以得到下面这个等式 F(i,n) = dp[i-1] * dp[n-i] 。举例，[1,2,3,4,…, i ,…,n-1,n]，以 i 为 根节点，那么左半边 [1,2,3,……,i-1] 和 右半边 [i+1,i+2,……,n-1,n] 分别能组成二叉排序树的不同个数相乘，即为以 i 为根节点，1-n 个数组成的二叉排序树的不同的个数，也即 F(i,n)。
注意，由于二叉排序树本身的性质，右边的子树一定比左边的子树，值都要大。所以这里只需要根节点把树分成左右，不需要再关心左右两边数字的大小，只需要关心数字的个数。
所以状态转移方程是 dp[i] = dp[0] * dp[n-1] + dp[1] * dp[n-2] + …… + dp[n-1] * dp[0]，最终要求的结果是 dp[n]
 */
// Time c O(n2) Space O(n)
func numTrees(n int) int {
	dp := make([]int, n + 1)
	dp[0], dp[1] = 1, 1
	for i := 2; i <= n; i++ {
		for j := 1; j <= i; j++ {
			dp[i] += dp[j - 1] * dp[i - j]
		}
	}

	return dp[n]
}
