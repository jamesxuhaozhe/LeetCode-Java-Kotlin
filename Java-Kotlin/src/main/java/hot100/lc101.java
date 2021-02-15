package hot100;

import common.datastructure.TreeNode;

public class lc101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    private static boolean isSym(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }

        return isSym(node1.left, node2.right) && isSym(node1.right, node2.left);
    }
}
