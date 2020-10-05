package tree._96;

import common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Problem link: https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class Solution {

    //Solution pretty much the same as problem 95(stupid solution)
    static class Solution1 {
        public int numTrees(int n) {
            if (n == 0) {
                return 0;
            }

            List<TreeNode> result = helper(1, n);
            return result.size();
        }

        private List<TreeNode> helper(int start, int end) {
            List<TreeNode> result = new ArrayList<>();
            if (start > end) {
                result.add(null);
                return result;
            }

            if (start == end) {
                result.add(new TreeNode(start));
                return result;
            }

            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTrees = helper(start, i - 1);
                List<TreeNode> rightTrees = helper(i + 1, end);
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        result.add(root);
                    }
                }
            }
            return result;
        }
    }

    /**
     * 假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则
     * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
     * <p>
     * 当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
     * f(i)=G(i−1)∗G(n−i)
     * <p>
     * 综合两个公式可以得到 卡特兰数 公式
     * G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
     * <p>
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
     */
    static class Solution2 {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                for (int j = 1; j < i + 1; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
}
