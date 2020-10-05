package tree._226;

import common.datastructure.TreeNode;

/**
 * Problem link: https://leetcode-cn.com/problems/invert-binary-tree/submissions/
 * <p>
 * Solution: just post order traversal
 */
public class _226 {

    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
