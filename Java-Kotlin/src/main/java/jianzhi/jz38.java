package jianzhi;

import common.datastructure.TreeNode;

//todo: use golang
public class jz38 {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) +1;
    }
}
