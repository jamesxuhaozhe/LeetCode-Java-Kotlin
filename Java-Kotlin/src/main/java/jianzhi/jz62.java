package jianzhi;

import common.datastructure.TreeNode;

public class jz62 {


    private int count = 0;
    private TreeNode result;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        //TreeNode result = null;

        inOrder(pRoot, k);

        return result;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inOrder(root.left, k);

        count++;
        if (count == k) {
            result = root;
            return;
        }
        if (count > k) {
            return;
        }
        inOrder(root.right, k);
    }
}
