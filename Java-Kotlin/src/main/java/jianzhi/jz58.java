package jianzhi;

import common.datastructure.TreeNode;

public class jz58 {

    private static boolean isSymm(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSymm(root1.left, root2.right) && isSymm(root1.right, root2.left);
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        return isSymm(pRoot.left, pRoot.right);
    }
}
