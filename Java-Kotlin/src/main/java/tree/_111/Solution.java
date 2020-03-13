package tree._111;

import common.datastructure.TreeNode;

/**
 * Problem link: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class Solution {

    /**
     * DFS
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0) {
            return right + 1;
        }

        if (right == 0) {
            return left + 1;
        }

        return Math.min(left, right) + 1;
    }

    /**
     * TODO use BFS
     */
}
