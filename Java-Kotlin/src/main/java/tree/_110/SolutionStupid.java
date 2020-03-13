package tree._110;

import common.datastructure.TreeNode;

public class SolutionStupid {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
