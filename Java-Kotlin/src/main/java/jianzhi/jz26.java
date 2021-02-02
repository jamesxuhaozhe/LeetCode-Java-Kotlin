package jianzhi;

import common.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class jz26 {

    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);

        TreeNode pre = list.get(0);
        TreeNode dummy = pre;
        for (int i = 1; i < list.size(); i++) {
            TreeNode cur = list.get(i);
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        return dummy;
    }

    private static void inOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }
}
