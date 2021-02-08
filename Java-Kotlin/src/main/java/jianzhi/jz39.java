package jianzhi;

import common.datastructure.TreeNode;

public class jz39 {

    private static boolean isBalanced(TreeNode node, IntHolder depth) {
        if (node == null) {
            depth.value = 0;
            return true;
        }

        IntHolder leftDepth = new IntHolder(0);
        IntHolder rightDepth = new IntHolder(0);
        if (!isBalanced(node.left, leftDepth) || !isBalanced(node.right, rightDepth)) {
            return false;
        }

        if (Math.abs(leftDepth.value - rightDepth.value) <= 1) {
            depth.value = 1 + Math.max(leftDepth.value, rightDepth.value);
            return true;
        }

        return false;
    }

    // see jianzhi book solution todo: use golang to do it again
    public boolean IsBalanced_Solution(TreeNode root) {
        IntHolder depth = new IntHolder(0);
        return isBalanced(root, depth);
    }

    private static class IntHolder {
        private int value;

        private IntHolder(int value) {
            this.value = value;
        }
    }
}
