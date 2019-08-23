package tree.balanced_binary_tree_110;

import common.datastructure.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = checkHeight(node.left);
        if ( leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(node.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (Math.abs(rightHeight - leftHeight) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
